package com.guo.mqtttimescaledb;

import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.mapper.MqttMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class MqtttimescaledbApplicationTests {
    @Autowired
    MqttMapper mqttMapper;

    @Test
    void contextLoads() {


        List<Mqtt> mqttList = mqttMapper.selectMeasureOrigin("test0506", 4);
        List<Mqtt> newList = new LinkedList<>();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<Long, List<Mqtt>> collect = mqttList.stream()
                .collect(Collectors.groupingBy(Mqtt::getPointlabel));

        for (Map.Entry<Long, List<Mqtt>> entry : collect.entrySet()) {
            Long pointLabel = entry.getKey();
            List<Mqtt> itemList = entry.getValue().stream().sorted(Comparator.comparing(Mqtt::getCollecttime)).collect(Collectors.toList());
//            Collections.sort(itemList, Comparator.comparing(Mqtt::getTemperature));
            Mqtt itemMin = itemList.stream().min(Comparator.comparing(Mqtt::getTemperature)).orElse(null);
            Mqtt itemMax = itemList.stream().max(Comparator.comparing(Mqtt::getTemperature)).orElse(null);

            if (itemMin.getCollecttime().isAfter(itemMax.getCollecttime())) {
                newList.add(new Mqtt(itemMax.getTemperature(), pointLabel, itemList.get(1).getCollecttime(), itemList.get(1).getNum()));
                newList.add(new Mqtt(itemMin.getTemperature(), pointLabel, itemList.get(3).getCollecttime(), itemList.get(3).getNum()));
            } else {
                newList.add(new Mqtt(itemMin.getTemperature(), pointLabel, itemList.get(1).getCollecttime(), itemList.get(1).getNum()));
                newList.add(new Mqtt(itemMax.getTemperature(), pointLabel, itemList.get(3).getCollecttime(), itemList.get(3).getNum()));
            }
        }
//        System.out.println(newList);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds() + "处理时间");
    }
}
