package com.guo.mqtttimescaledb;

import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.mapper.MqttMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
class MqtttimescaledbApplicationTests {
    @Autowired
    MqttMapper mqttMapper;

    @Test
    void contextLoads() {
        List<Mqtt> mqttList = mqttMapper.selectMeasureOrigin("test0407", 4);
//        i为点数数量
        List<Mqtt> list = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Mqtt maxMqtt = new Mqtt();
            Mqtt minMqtt = new Mqtt();
            int finalI = i;
            List<Mqtt> collect = mqttList.stream()
                    .filter(data -> data.getPointlabel() == finalI)
                    .collect(Collectors.toList());
            double maxTemperature = collect.stream()
                    .mapToDouble(Mqtt::getTemperature)
                    .max().orElse(0);

            Optional<Mqtt> maxTemperatureObject = collect.stream()
                    .max(Comparator.comparingDouble(Mqtt::getTemperature));
            System.out.println(maxTemperatureObject);
            OffsetDateTime maxOffsetDateTime = maxTemperatureObject.map(Mqtt::getCollecttime).orElse(null);

            System.out.println("最大值对应的时间" + maxOffsetDateTime);

            double minTemperature = collect.stream()
                    .mapToDouble(Mqtt::getTemperature)
                    .min().orElse(0);

            Optional<Mqtt> minTemperatureObject = collect.stream()
                    .min(Comparator.comparingDouble(Mqtt::getTemperature));
            System.out.println(minTemperatureObject);
            OffsetDateTime minOffsetDateTime = minTemperatureObject.map(Mqtt::getCollecttime).orElse(null);
            System.out.println("最小值对应的时间" + minOffsetDateTime);
            maxMqtt.setTemperature(Float.parseFloat(String.valueOf(maxTemperature)));
            minMqtt.setTemperature(Float.parseFloat(String.valueOf(minTemperature)));
//            固定的早晚时间
            OffsetDateTime lastCollectTime = collect.get(0).getCollecttime();
            OffsetDateTime firstCollectTime = collect.get(2).getCollecttime();

            maxMqtt.setPointlabel(Long.parseLong(String.valueOf(i)));
            minMqtt.setPointlabel(Long.parseLong(String.valueOf(i)));
            //判断哪个数值在前面
            if (maxOffsetDateTime.compareTo(minOffsetDateTime) > 0) {
                maxMqtt.setCollecttime(lastCollectTime);
                minMqtt.setCollecttime(firstCollectTime);
                System.out.println("maxOffsetDateTime更大");
                list.add(minMqtt);
                list.add(maxMqtt);
            } else {
                maxMqtt.setCollecttime(firstCollectTime);
                minMqtt.setCollecttime(lastCollectTime);
                System.out.println("minOffsetDateTime更大");
                list.add(maxMqtt);
                list.add(minMqtt);
            }
            System.out.println("Temperature最大值：" + maxTemperature);
            System.out.println("Temperature最小值：" + minTemperature);
            System.out.println("Collecttime中间时间：" + firstCollectTime);
            System.out.println("Collecttime最后时间：" + lastCollectTime);
            System.out.println("当前label为" + i);
        }
        boolean insert = mqttMapper.insertTableMeasureData("test0407", "measuredata" + 4, list);
        if (insert) {
            System.out.println("压缩" + 4 + "成功");
        } else {
            System.out.println("压缩" + 4 + "失败");
        }

    }

}
