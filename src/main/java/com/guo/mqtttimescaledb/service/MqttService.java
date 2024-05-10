package com.guo.mqtttimescaledb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.eneity.testInfoJson;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【mqtt】的数据库操作Service
 * @createDate 2023-11-14 14:20:54
 */
public interface MqttService extends IService<Mqtt> {

    //动态插入
    boolean insertTableMeasureOriginData(String name, List<Mqtt> mqttList);

    //压缩表数据4处理及插入
    boolean insertTableMeasureData4(String name, int value, int label);

    //压缩表数据8-128处理及插入
    boolean insertTableMeasureDataOther(String name, int value, int label);

    //查询序列，作为记录第几次采集
    String selectFlagNum(String sequenceName);

    //动态创建模式、表、触发器、序列
    boolean insertInitTable(String name, testInfoJson json);

    //设置超表
    boolean updateHypertable(String name);

    //删除模式
    boolean dropSchema(String name);

    //查询全部试验信息表
    List<Testinfo> selectAll(int current, int size, String testnamekeyword);

    //查询全部试验信息表给前端3d界面用
    List<Testinfo> threeDimensionalSelectAll();
}
