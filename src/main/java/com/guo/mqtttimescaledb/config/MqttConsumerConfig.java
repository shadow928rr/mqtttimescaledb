package com.guo.mqtttimescaledb.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.mqtttimescaledb.eneity.MqttEntity;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.mapper.TestinfoMapper;
import com.guo.mqtttimescaledb.service.ControlorigindataService;
import com.guo.mqtttimescaledb.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MqttConsumerConfig {
    @Autowired
    private MqttService mqttService;
    @Autowired
    private ControlorigindataService controlorigindataService;
    //    @Autowired
//    private MqttConsumerCallBack mqttConsumerCallBack;
    @Resource
    private TestinfoMapper testinfoMapper;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    /**
     * 客户端对象
     */
//    private MqttClient client;

    /**
     * 在bean初始化后连接到服务器
     */
//    @PostConstruct
//    public void init() {
//        connect();
//    }

    /**
     * 客户端连接服务端
     */
    public boolean connect(String topic) {
//        System.out.println(topic + "=============");
        try {
            Testinfo testinfo = testinfoMapper.selectOne(new QueryWrapper<Testinfo>().eq("topic", topic));
            if (testinfo == null) {
            } else {
                //不存在创建新的客户端并监听
                if (testinfo.getClient() == null) {
                    MqttConsumerCallBack mqttcallback = new MqttConsumerCallBack(mqttService);
                    mqttcallback.setTopics(topic);
//                mqttConsumerCallBack.setMqttService(mqttService);
                    //创建MQTT客户端对象，clientid为topic，为了省事
                    MqttClient client = new MqttClient(hostUrl, topic, new MemoryPersistence());
                    //连接设置
                    MqttConnectOptions options = new MqttConnectOptions();
                    //是否清空session，设置为false表示服务器会保留客户端的连接记录，客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
                    //设置为true表示每次连接到服务端都是以新的身份
                    options.setCleanSession(true);
                    //设置连接用户名
                    options.setUserName(username);
                    //设置连接密码
                    options.setPassword(password.toCharArray());
                    //设置超时时间，单位为秒
                    options.setConnectionTimeout(100);
                    //设置心跳时间 单位为秒，表示服务器每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
                    options.setKeepAliveInterval(20);
                    //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
                    options.setWill("willTopic", (clientId + "与服务器断开连接").getBytes(), 0, false);
                    //设置回调
//                client.setCallback(new MqttConsumerCallBack(mqttService));
//                client.setCallback(mqttConsumerCallBack);
//                    client.setTimeToWait(120000);
                    client.setCallback(mqttcallback);
                    client.connect(options);
                    //订阅主题
                    //消息等级，和主题数组一一对应，服务端将按照指定等级给订阅了主题的客户端推送消息
                    int[] qos = {1, 1};
                    //主题
//                String[] topics = {"topic1", "topic2"};
//                    List<String> topics = new ArrayList<>();
//                    topics.add(topic);
                    //订阅主题
                    client.subscribe("kmexp/" + topic, 0);

                    MqttEntity mqttEntity = new MqttEntity(username, password, hostUrl, clientId, topic);

                    Testinfo testinfo1 = new Testinfo();
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(mqttEntity);
                    testinfo1.setClient(json);
                    testinfoMapper.update(testinfo1, new QueryWrapper<Testinfo>().eq("topic", topic));
                    return true;
                } else {
                    ObjectMapper objectMapper = new ObjectMapper();
                    MqttEntity mqttEntity = objectMapper.readValue(testinfo.getClient(), MqttEntity.class);

                    MqttClient client = new MqttClient(hostUrl, topic, new MemoryPersistence());
                    MqttConsumerCallBack mqttcallback = new MqttConsumerCallBack(mqttService);
                    mqttcallback.setTopics(topic);
//                mqttConsumerCallBack.setMqttService(mqttService);
                    //连接设置
                    MqttConnectOptions options = new MqttConnectOptions();
                    //是否清空session，设置为false表示服务器会保留客户端的连接记录，客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
                    //设置为true表示每次连接到服务端都是以新的身份
                    options.setCleanSession(true);
                    //设置连接用户名
                    options.setUserName(username);
                    //设置连接密码
                    options.setPassword(password.toCharArray());
                    //设置超时时间，单位为秒
                    options.setConnectionTimeout(100);
                    //设置心跳时间 单位为秒，表示服务器每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
                    options.setKeepAliveInterval(20);
                    //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
                    options.setWill("willTopic", (clientId + "与服务器断开连接").getBytes(), 0, false);
                    //设置回调
//            client.setCallback(new MqttConsumerCallBack(mqttService));
//                mqttClient.setCallback(mqttConsumerCallBack);
//                    client.setTimeToWait(120000);
                    client.setCallback(mqttcallback);
                    client.connect(options);
                    //订阅主题
                    //消息等级，和主题数组一一对应，服务端将按照指定等级给订阅了主题的客户端推送消息
//                int[] qos = {1, 1};
                    //主题
//                String[] topics = {"topic1", "topic2"};
                    //订阅主题
                    client.subscribe("kmexp/" + mqttEntity.getTopics(), 0);
                    return true;
                }
            }
        } catch (MqttException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean controlConnect(String topic) {
        try {
            MqttControlCallBack mqttControlCallBack = new MqttControlCallBack(controlorigindataService);
            mqttControlCallBack.setTopics(topic);
            //创建MQTT客户端对象，clientid为topic，为了省事
            MqttClient client = null;

            client = new MqttClient(hostUrl, topic, new MemoryPersistence());

            //连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            //是否清空session，设置为false表示服务器会保留客户端的连接记录，客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
            //设置为true表示每次连接到服务端都是以新的身份
            options.setCleanSession(true);
            //设置连接用户名
            options.setUserName(username);
            //设置连接密码
            options.setPassword(password.toCharArray());
            //设置超时时间，单位为秒
            options.setConnectionTimeout(100);
            //设置心跳时间 单位为秒，表示服务器每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
            options.setKeepAliveInterval(20);
            //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
            options.setWill("willTopic", (clientId + "与服务器断开连接").getBytes(), 0, false);
            //设置回调
//                client.setCallback(new MqttConsumerCallBack(mqttService));
//                client.setCallback(mqttConsumerCallBack);
//                    client.setTimeToWait(120000);
            client.setCallback(mqttControlCallBack);
            client.connect(options);
            //消息等级，和主题数组一一对应，服务端将按照指定等级给订阅了主题的客户端推送消息
            int[] qos = {1, 1};
            //订阅主题
            client.subscribe("kmexp/" + topic, 0);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return true;
    }

//    public void connect() {
//        try {
//            mqttConsumerCallBack.setMqttService(mqttService);
//            //创建MQTT客户端对象
//            client = new MqttClient(hostUrl, clientId, new MemoryPersistence());
//            //连接设置
//            MqttConnectOptions options = new MqttConnectOptions();
//            //是否清空session，设置为false表示服务器会保留客户端的连接记录，客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
//            //设置为true表示每次连接到服务端都是以新的身份
//            options.setCleanSession(true);
//            //设置连接用户名
//            options.setUserName(username);
//            //设置连接密码
//            options.setPassword(password.toCharArray());
//            //设置超时时间，单位为秒
//            options.setConnectionTimeout(100);
//            //设置心跳时间 单位为秒，表示服务器每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
//            options.setKeepAliveInterval(20);
//            //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
//            options.setWill("willTopic", (clientId + "与服务器断开连接").getBytes(), 0, false);
//            //设置回调
////            client.setCallback(new MqttConsumerCallBack(mqttService));
//            client.setCallback(mqttConsumerCallBack);
//            client.connect(options);
//            //订阅主题
//            //消息等级，和主题数组一一对应，服务端将按照指定等级给订阅了主题的客户端推送消息
//            int[] qos = {1, 1};
//            //主题
//            String[] topics = {"topic1", "topic2"};
//            //订阅主题
//            client.subscribe(defaultTopic, 1);
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 断开连接
     */
//    public void disConnect() {
//        try {
//            client.disconnect();
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 断开连接
     */
    public boolean disConnect(String topic) {
        try {
//            Record record = recordMapper.selectOne(new QueryWrapper<Record>().eq("topic", topic));
            MqttClient client = new MqttClient(hostUrl, topic, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            //是否清空session，设置为false表示服务器会保留客户端的连接记录，客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
            //设置为true表示每次连接到服务端都是以新的身份
            options.setCleanSession(true);
            //设置连接用户名
            options.setUserName(username);
            //设置连接密码
            options.setPassword(password.toCharArray());
            //设置超时时间，单位为秒
            options.setConnectionTimeout(100);
            //设置心跳时间 单位为秒，表示服务器每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
            options.setKeepAliveInterval(20);
            //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
            options.setWill("willTopic", (clientId + "与服务器断开连接").getBytes(), 0, false);
            client.connect(options);

            client.disconnect();
            client.unsubscribe(topic);
            client.close();
//            ObjectMapper objectMapper = new ObjectMapper();
//            MqttClient mqttClient = objectMapper.readValue(record.getClient(), MqttClient.class);
//            mqttClient.disconnect();
            return true;
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 订阅主题
     */
//    public void subscribe(String topic, int qos) {
//        try {
//            client.subscribe(topic, qos);
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }
}