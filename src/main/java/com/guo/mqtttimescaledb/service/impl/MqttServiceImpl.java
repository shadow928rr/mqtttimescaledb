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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 57864
 * @description 针对表【mqtt】的数据库操作Service实现
 * @createDate 2023-11-14 14:20:54
 */
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
    public boolean insertTable(String name, List<Mqtt> mqttList) {
        return mqttMapper.insertTable(name, mqttList);
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
                mqttMapper.createTrigger(name);
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




