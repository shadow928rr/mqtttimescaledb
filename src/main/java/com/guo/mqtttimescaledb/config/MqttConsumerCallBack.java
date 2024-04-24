package com.guo.mqtttimescaledb.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.service.MqttService;
import lombok.extern.log4j.Log4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

@Log4j
@Component
public class MqttConsumerCallBack implements MqttCallback {
//    @Resource
//    MqttMapper mqttMapper;

    public MqttService getMqttService() {
        return mqttService;
    }

    public void setMqttService(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    private MqttService mqttService;
    private String topics;

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public MqttConsumerCallBack(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    /**
     * 客户端断开连接的回调
     */
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println(throwable.toString());
        System.out.println(throwable.getMessage() + "与服务器断开连接，可重连");
    }

    /**
     * 消息到达的回调
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws IOException {
//        log.info("接收消息主题 : " + topic);
//        log.info("接收消息Qos : " + message.getQos());
//        log.info("接收消息内容 : " + new String(message.getPayload()));
//        log.info("接收消息retained : " + message.isRetained());
//        System.out.printf("接收消息主题 : %s%n", topic);
//        System.out.printf("接收消息Qos : %d%n", message.getQos());
//        System.out.printf("接收消息内容 : %s%n", new String(message.getPayload()));
//        System.out.printf("接收消息retained : %b%n", message.isRetained());

        //因为新增加了控制，需要判断是控制还是采集，现在这个处理采集mqtt

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(message.getPayload(), JsonNode.class);

        StopWatch stopWatch = new StopWatch();
        JsonNode payLoad = jsonNode.get("PayLoad");
        ArrayList<Mqtt> mqttArrayList = new ArrayList<>();
        String i = mqttService.selectFlagNum(topics);
        //System.out.println("当前接收到第" + i + "条数据");
        log.info("当前接收到第" + i + "条数据");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(jsonNode.get("CollectTime").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
//            ZoneId chinaZoneId = ZoneId.of("Asia/Shanghai");
//            ZonedDateTime zonedDateTime = offsetDateTime.atZoneSameInstant(chinaZoneId);
//            OffsetDateTime DateTime = zonedDateTime.toOffsetDateTime();
//            int j = 1;
        for (JsonNode node : payLoad) {
            Mqtt mqtt = new Mqtt();
//                mqtt.setId(UUID.randomUUID().toString());
            mqtt.setCollecttime(offsetDateTime);
            mqtt.setTemperature(Float.parseFloat(node.get("Temperature").toString()));
            mqtt.setPointlabel(Long.parseLong(node.get("Index").toString()));
//                mqtt.setPlainvalue(Float.parseFloat(node.get("PlainValue").toString()));
            mqtt.setNum(Long.parseLong(i));
            mqttArrayList.add(mqtt);
        }
//            还缺动态创建表、动态插入、动态创建触发器（写在Controller层）
//            boolean flag = mqttService.insertMqttList(mqttArrayList);
        stopWatch.start();
        boolean flag = mqttService.insertTable(topics, mqttArrayList);
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "落库时间");

        //System.out.println(stopWatch.getTotalTimeSeconds() + "落库时间");


//        Mqtt mqtt = new Mqtt(UUID.randomUUID().toString(), new String(message.getPayload()));
//        try {
//            int i = mqttService.insertMqttMessage(mqtt);
//            log.info("成功插入了" + i + "条数据" + mqtt.toString());
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
    }

    /**
     * 消息发布成功的回调
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

}