package com.guo.mqtttimescaledb;

import com.guo.mqtttimescaledb.mapper.MqttMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqtttimescaledbApplicationTests {
    //    @Autowired
//    private MqttService mqttService;
    @Autowired
    MqttMapper mqttMapper;

//    public String jsonString = "{\n" +
//            "  \"ErrorCode\": 200,\n" +
//            "  \"ErrorMessage\": \"Success\",\n" +
//            "  \"CollectTime\": \"2023-11-06T17:26:00.0058129+08:00\",\n" +
//            "  \"PayLoad\": [\n" +
//            "    {\n" +
//            "      \"Label\": 1,\n" +
//            "      \"PlainValue\": 0.2517119341,\n" +
//            "      \"CaculatedValue\": 21.416\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"Label\": 2,\n" +
//            "      \"PlainValue\": 0.2514815748,\n" +
//            "      \"CaculatedValue\": 21.41\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"Label\": 3,\n" +
//            "      \"PlainValue\": 0.2551479105,\n" +
//            "      \"CaculatedValue\": 21.5\n" +
//            "    }]}";

    @Test
    void contextLoads() {

//        Mqtt mqtt = new Mqtt();
//        Mqtt mqtt1 = new Mqtt();
//        mqtt.setId("5");
//        mqtt1.setId("6");
//        mqtt.setTemperature(5.f);
//        mqtt.setCollecttime(new OffsetDateTime());
//        mqtt1.setCollecttime(new OffsetDateTimeTypeHandler());
//        mqtt1.setTemperature(6.f);
//        mqtt.setLabel(Long.parseLong("5"));
//        mqtt1.setLabel(Long.parseLong("6"));
//        mqtt.setNum(Long.parseLong("5"));
//        mqtt1.setNum(Long.parseLong("6"));
//        ArrayList<Mqtt> mqttArrayList = new ArrayList<>();
//
//        mqttArrayList.add(mqtt);
//        mqttArrayList.add(mqtt1);
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("tableName","mqtt");
//        paramMap.put("mqtt",mqtt);
//        mqttMapper.insertTable("mqtt", mqttArrayList);
//        String s = mqttMapper.selectFlagNum();
//        String s1 = mqttMapper.setFlagNum();
//        System.out.println(s);
//        System.out.println(s1);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(jsonString);
//            JsonNode payLoad = jsonNode.get("PayLoad");
//            ArrayList<Mqtt> mqttArrayList = new ArrayList<>();
//            for (JsonNode node : payLoad) {
//                Mqtt mqtt = new Mqtt();
//                mqtt.setId("1");
//                mqtt.setCollecttime(jsonNode.get("CollectTime").toString());
//                mqtt.setCaculatedvalue(Float.parseFloat(node.get("CaculatedValue").toString()));
//                mqtt.setIndex(node.get("Index").toString());
//                mqtt.setPlainvalue(Float.parseFloat(node.get("PlainValue").toString()));
//                mqttArrayList.add(mqtt);
//            }
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        int i = mqttService.insertMqttMessage(new Mqtt(UUID.randomUUID().toString(), "asd"));
//        System.out.println(i);
    }

}
