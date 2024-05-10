package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.eneity.TestReturn;
import com.guo.mqtttimescaledb.eneity.testInfoJson;
import com.guo.mqtttimescaledb.mapper.MqttMapper;
import com.guo.mqtttimescaledb.mapper.TestinfoMapper;
import com.guo.mqtttimescaledb.service.MqttService;
import com.guo.mqtttimescaledb.service.TestinfoService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 57864
 * @description 针对表【mqtt】的数据库操作Service实现
 * @createDate 2023-11-14 14:20:54
 */
@Log4j
@Service
public class MqttServiceImpl extends ServiceImpl<MqttMapper, Mqtt> implements MqttService {
    @Resource
    MqttMapper mqttMapper;
    @Resource
    TestinfoMapper testinfoMapper;
    @Resource
    TestinfoService testinfoService;

    //批量动态添加
    @Transactional
    @Override
    public boolean insertTableMeasureOriginData(String name, List<Mqtt> mqttList) {
        return mqttMapper.insertTableMeasureOriginData(name, mqttList);
    }

    //压缩表数据4-128处理及插入

    /**
     * label测点数量
     * value查询4的数量及对应的measuredata4
     * schemaName模式名称
     */
    @Transactional
    @Override
    public boolean insertTableMeasureData4(String schemaName, int value, int label) {
        StopWatch stopWatch = new StopWatch();
        List<Mqtt> list = new LinkedList<>();
        try {
//            stopWatch.start();
            List<Mqtt> mqttList = mqttMapper.selectMeasureOrigin(schemaName, value);
//            stopWatch.stop();
//            log.info(stopWatch.getTotalTimeSeconds() + "查询时间");
//        i为点数数量
            stopWatch.start();
            for (int i = 1; i <= label; i++) {
                Mqtt maxMqtt = new Mqtt();
                Mqtt minMqtt = new Mqtt();
                int finalI = i;
                List<Mqtt> collect = mqttList.stream()
                        .filter(data -> data.getPointlabel() == finalI)
                        .collect(Collectors.toList());
                double maxTemperature = collect.stream()
                        .mapToDouble(Mqtt::getTemperature)
                        .max().orElse(0);

                Optional<Mqtt> maxTemperatureObject = collect.parallelStream()
                        .max(Comparator.comparingDouble(Mqtt::getTemperature));
//            System.out.println(maxTemperatureObject);
                OffsetDateTime maxOffsetDateTime = maxTemperatureObject.map(Mqtt::getCollecttime).orElse(null);

//            System.out.println("最大值对应的时间" + maxOffsetDateTime);

                double minTemperature = collect.stream()
                        .mapToDouble(Mqtt::getTemperature)
                        .min().orElse(0);

                Optional<Mqtt> minTemperatureObject = collect.parallelStream()
                        .min(Comparator.comparingDouble(Mqtt::getTemperature));
//            System.out.println(minTemperatureObject);
                OffsetDateTime minOffsetDateTime = minTemperatureObject.map(Mqtt::getCollecttime).orElse(null);
//            System.out.println("最小值对应的时间" + minOffsetDateTime);
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
                    maxMqtt.setNum(collect.get(0).getNum());

                    minMqtt.setCollecttime(firstCollectTime);
                    minMqtt.setNum(collect.get(2).getNum());
//                System.out.println("maxOffsetDateTime更大");
                    list.add(minMqtt);
                    list.add(maxMqtt);
                } else {
                    maxMqtt.setCollecttime(firstCollectTime);
                    maxMqtt.setNum(collect.get(2).getNum());

                    minMqtt.setCollecttime(lastCollectTime);
                    minMqtt.setNum(collect.get(0).getNum());

//                System.out.println("minOffsetDateTime更大");
                    list.add(maxMqtt);
                    list.add(minMqtt);
                }


//            System.out.println("Temperature最大值：" + maxTemperature);
//            System.out.println("Temperature最小值：" + minTemperature);
//            System.out.println("Collecttime中间时间：" + firstCollectTime);
//            System.out.println("Collecttime最后时间：" + lastCollectTime);
//            System.out.println("当前label为" + i);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "处理时间");
        stopWatch.start();
        boolean insert = mqttMapper.insertTableMeasureData(schemaName, "measuredata" + value, list);
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "插入时间");
        if (insert) {
            System.out.println("压缩" + value + "成功");
        } else {
            System.out.println("压缩" + value + "失败");
        }
        return insert;
    }

    /**
     * label测点数量
     * value查询8-128的数量及对应的measuredata8-128
     * schemaName模式名称
     */
    @Transactional
    @Override
    public boolean insertTableMeasureDataOther(String schemaName, int value, int label) {
        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        List<Mqtt> mqttList = mqttMapper.selectMeasureData(schemaName, value / 2);
//        stopWatch.stop();
//        log.info(stopWatch.getTotalTimeSeconds() + "查询时间");
//        i为点数数量
        List<Mqtt> list = new LinkedList<>();
        stopWatch.start();
        for (int i = 1; i <= label; i++) {
            Mqtt maxMqtt = new Mqtt();
            Mqtt minMqtt = new Mqtt();
            int finalI = i;
            List<Mqtt> collect = mqttList.stream()
                    .filter(data -> data.getPointlabel() == finalI)
                    .collect(Collectors.toList());
            double maxTemperature = collect.stream()
                    .mapToDouble(Mqtt::getTemperature)
                    .max().orElse(0);

            Optional<Mqtt> maxTemperatureObject = collect.parallelStream()
                    .max(Comparator.comparingDouble(Mqtt::getTemperature));
//            System.out.println(maxTemperatureObject);
            OffsetDateTime maxOffsetDateTime = maxTemperatureObject.map(Mqtt::getCollecttime).orElse(null);

//            System.out.println("最大值对应的时间" + maxOffsetDateTime);

            double minTemperature = collect.stream()
                    .mapToDouble(Mqtt::getTemperature)
                    .min().orElse(0);

            Optional<Mqtt> minTemperatureObject = collect.parallelStream()
                    .min(Comparator.comparingDouble(Mqtt::getTemperature));
//            System.out.println(minTemperatureObject);
            OffsetDateTime minOffsetDateTime = minTemperatureObject.map(Mqtt::getCollecttime).orElse(null);
//            System.out.println("最小值对应的时间" + minOffsetDateTime);
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
                maxMqtt.setNum(collect.get(0).getNum());

                minMqtt.setCollecttime(firstCollectTime);
                minMqtt.setNum(collect.get(2).getNum());
//                System.out.println("maxOffsetDateTime更大");
                list.add(minMqtt);
                list.add(maxMqtt);
            } else {
                maxMqtt.setCollecttime(firstCollectTime);
                maxMqtt.setNum(collect.get(2).getNum());

                minMqtt.setCollecttime(lastCollectTime);
                minMqtt.setNum(collect.get(0).getNum());

//                System.out.println("minOffsetDateTime更大");
                list.add(maxMqtt);
                list.add(minMqtt);
            }


//            System.out.println("Temperature最大值：" + maxTemperature);
//            System.out.println("Temperature最小值：" + minTemperature);
//            System.out.println("Collecttime中间时间：" + firstCollectTime);
//            System.out.println("Collecttime最后时间：" + lastCollectTime);
//            System.out.println("当前label为" + i);
        }
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "处理时间");
        stopWatch.start();
        boolean insert = mqttMapper.insertTableMeasureData(schemaName, "measuredata" + value, list);
        stopWatch.stop();
        log.info(stopWatch.getTotalTimeSeconds() + "插入时间");
        if (insert) {
            System.out.println("压缩" + value + "成功");
        } else {
            System.out.println("压缩" + value + "失败");
        }
        return insert;
    }

    @Override
    public String selectFlagNum(String sequenceName) {
        return mqttMapper.selectFlagNum(sequenceName);
    }

    //创建模式、表、触发器、超表、序列
    //总表origindata，压缩表measuredata4-128，创建触发器，创建超表，创建序列。
    @Transactional
    @Override
    public boolean insertInitTable(String name, testInfoJson json) {
        Testinfo topic = testinfoService.getOne(new QueryWrapper<Testinfo>().eq("topic", name));
        if (topic == null) {
            try {
                Testinfo testinfo = new Testinfo();
                testinfo.setId(UUID.randomUUID().toString());
                testinfo.setTestname(json.getTestname());
                testinfo.setPosition(json.getPosition());
                testinfo.setFacility(json.getFacility());
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                testinfo.setCreatetime(Timestamp.valueOf(json.getCreatetime()));
                testinfo.setSchemaname(name);
                testinfo.setTablename("measureorigindata");
                testinfo.setTablename4("measuredata" + "4");
                testinfo.setTablename8("measuredata" + "8");
                testinfo.setTablename16("measuredata" + "16");
                testinfo.setTablename32("measuredata" + "32");
                testinfo.setTablename64("measuredata" + "64");
                testinfo.setTablename128("measuredata" + "128");
//                控制表待添加
//                testinfo.setControlTablename("measuredata");
//                testinfo.setControlTablename4("measuredata"+ "4");
//                testinfo.setControlTablename8("measuredata"+ "8");
//                testinfo.setControlTablename16("measuredata"+ "16");
//                testinfo.setControlTablename32("measuredata"+ "32");
//                testinfo.setControlTablename64("measuredata"+ "64");
//                testinfo.setControlTablename128("measuredata"+ "128");
                testinfo.setTeststatus(0);
//                LocalDateTime currentDateTime = LocalDateTime.now();
//                OffsetDateTime offsetDateTime = currentDateTime.atOffset(ZoneOffset.ofHours(8)); // 这里假设使用 UTC 时区
//                testinfo.setBegintime(Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()));
                testinfo.setTopic(name);

                //创建模式
                mqttMapper.createSchema(name);
                //创建总表
                mqttMapper.createTableMeasureOriginData(name, "measureorigindata");
                //创建配置信息表
                mqttMapper.createMeasureInfoTable(name, "measureinfo");
                //创建图数据保存表
                mqttMapper.createPlotInfoTable(name, "plotinfo");//创建图数据保存表
                //创建报警解决方案表
                mqttMapper.createTableAlarmSolution(name, "alarmsolution");
                //新增控制表初始化配置表
                mqttMapper.createTableControlInfo(name, "controlinfo");
                //新增加控制原始数据
                mqttMapper.createTableControlOriginData(name, "controlorigindata");
                //新增加工况表
                mqttMapper.createTableWorkForm(name, "workform");
                //创建采集缓存表
                mqttMapper.createMeasureCacheTable(name, "measurecache");
                //创建控制缓存表
                mqttMapper.createControlCacheTable(name, "controlcache");
                int[] sizes = {4, 8, 16, 32, 64, 128};
                for (int size : sizes) {
                    //创建采集压缩表
                    mqttMapper.createTableMeasureData(name, "measuredata" + size);
                    //创建控制压缩表
                    mqttMapper.createTableControlData(name, "controldata" + size);
                    //将创建的表转为超表,需要事务提交后
//                mqttMapper.updateHypertable(name);
                    //创建对应序列，通过触发器对缓存表插入数据不在需要
//                    mqttMapper.createSequence(name, "measuredata" + size + "_id_seq");
                }
                //创建总表的num序列
                mqttMapper.createSequence(name, "measureorigindata" + "_id");
                //创建触发器
//                mqttMapper.createTrigger(name);
                //试验数据总表插入
                testinfoMapper.insert(testinfo);
//                testinfoService.save(testinfo);
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        } else {
            //已创建模式、表等
            return false;
        }

        return true;
    }

    //设置为超表
    @Transactional
    @Override
    public boolean updateHypertable(String name) {
        String[] sizes = {"measureorigindata", "measuredata4", "measuredata8", "measuredata16", "measuredata32", "measuredata64", "measuredata128", "controlorigindata", "controldata4", "controldata8", "controldata16", "controldata32", "controldata64", "controldata128"};
        for (String size : sizes) {
            //将创建的表转为超表,需要事务提交后
            String str = mqttMapper.updateHypertable(name, size);
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean dropSchema(String name) {
        return mqttMapper.dropSchema(name);
    }

    @Override
    public List<Testinfo> selectAll(int current, int size, String testnamekeyword) {
        Page<Testinfo> page = new Page<>(current, size);
        QueryWrapper<Testinfo> wrapper = new QueryWrapper<>();
        wrapper.select("testname", "schemaname", "topic", "position", "facility", "begintime", "createtime", "teststatus");
        wrapper.orderByDesc("createtime");
        wrapper.like("testname", testnamekeyword);
        IPage<Testinfo> userPage = testinfoMapper.selectPage(page, wrapper);
        System.out.println("集合：" + userPage.getRecords());
        System.out.println("总条数：" + userPage.getTotal());
        System.out.println("当前页：" + userPage.getCurrent());
        return userPage.getRecords();
    }

    @Override
    public List<Testinfo> threeDimensionalSelectAll() {
        QueryWrapper<Testinfo> wrapper = new QueryWrapper<>();
        wrapper.select("testname", "schemaname", "topic", "begintime", "teststatus");
        wrapper.orderByDesc("createtime");
        return testinfoMapper.selectList(wrapper);
    }
}




