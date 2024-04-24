package com.guo.mqtttimescaledb.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.mqtttimescaledb.eneity.Controlorigindata;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.service.ControlorigindataService;
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

@Log4j
@Component
public class MqttControlCallBack implements MqttCallback {

    public ControlorigindataService getControlorigindataService() {
        return controlorigindataService;
    }

    public void setControlorigindataService(ControlorigindataService controlorigindataService) {
        this.controlorigindataService = controlorigindataService;
    }

    private ControlorigindataService controlorigindataService;
    private String topics;

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public MqttControlCallBack(ControlorigindataService controlorigindataService) {
        this.controlorigindataService = controlorigindataService;
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
        //因为新增加了控制，需要判断是控制还是采集，现在这个处理采集的mqtt
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(message.getPayload(), JsonNode.class);
        StopWatch stopWatch = new StopWatch();
        JsonNode payLoad = jsonNode.get("PayLoad");
        ArrayList<Controlorigindata> controlorigindataArrayList = new ArrayList<>();

        String[] split = topic.split("/");
        String schemaName = split[1];
        String sequenceName = split[2];

        String i = controlorigindataService.selectFlagNum(schemaName, sequenceName);
        log.info("当前接收到第" + i + "条数据");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(jsonNode.get("CollectTime").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        for (JsonNode node : payLoad) {
            Controlorigindata controlorigindata = new Controlorigindata();
            controlorigindata.setLoopid(Integer.parseInt(node.get("LoopId").toString()));
            controlorigindata.setCurrent(Float.parseFloat(node.get("Current").toString()));
            controlorigindata.setVoltage(Integer.parseInt(node.get("Voltage").toString()));
            controlorigindata.setPower(Float.parseFloat(node.get("Power").toString()));
            controlorigindata.setCalculateerror(Float.parseFloat(node.get("CalculateError").toString()));
            controlorigindata.setCalculatecurrent(Float.parseFloat(node.get("CalculateCurrent").toString()));
            controlorigindata.setCalculatetemperature(Float.parseFloat(node.get("CalculateTemperature").toString()));
            controlorigindata.setIntegralvalue(Float.parseFloat(node.get("IntegralValue").toString()));
            controlorigindata.setDerivativevalue(Float.parseFloat(node.get("DerivativeValue").toString()));
            controlorigindata.setCollecttime(offsetDateTime);
            controlorigindata.setGroupname(jsonNode.get("GroupName").asText());
            controlorigindata.setNum(Integer.parseInt(i));
            controlorigindataArrayList.add(controlorigindata);
        }
//            还缺动态创建表、动态插入、动态创建触发器（写在Controller层）
//            boolean flag = mqttService.insertMqttList(mqttArrayList);
        stopWatch.start();
        boolean flag = controlorigindataService.insertTable(topics, controlorigindataArrayList);
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "落库时间");
    }

    /**
     * 消息发布成功的回调
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

}
