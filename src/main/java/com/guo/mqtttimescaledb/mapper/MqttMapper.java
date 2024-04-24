package com.guo.mqtttimescaledb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【mqtt】的数据库操作Mapper
 * @createDate 2023-11-14 14:20:54
 * @Entity com.guo.mqtttimescaledb.eneity.Mqtt
 */
public interface MqttMapper extends BaseMapper<Mqtt> {
    //查询序列值并加一
    String selectFlagNum(@Param("sequenceName") String sequenceName);

    //将序列值归为1
    String setFlagNum(@Param("sequenceName") String sequenceName);

    //动态批量插入
    boolean insertTable(@Param("schemaName") String schemaName, @Param("mqttList") List<Mqtt> mqttList);

    //动态创建模式
    boolean createSchema(@Param("schemaName") String schemaName);

    //动态指定模式创建总表
    boolean createTableMeasureOriginData(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //动态指定模式创建采集压缩表
    boolean createTableMeasureData(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //动态指定模式创建采集压缩表
    boolean createTableControlData(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //创建配置信息表
    boolean createMeasureInfoTable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //在指定模式下创建保存图数据的表
    boolean createPlotInfoTable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //新增加监视表
    boolean createTableAlarmSolution(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //新增加控制表
    boolean createTableControlInfo(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //控制总表
    boolean createTableControlOriginData(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //工况表
    boolean createTableWorkForm(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //创建采集缓存表
    boolean createMeasureCacheTable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //创建控制缓存表
    boolean createControlCacheTable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //动态创建超表
    String updateHypertable(@Param("schemaName") String schemaName, @Param("tableName") String tableName);

    //动态创建触发器
    boolean createTrigger(@Param("schemaName") String schemaName);

    //删除模式
    boolean dropSchema(@Param("schemaName") String schemaName);

    //动态创建序列
    boolean createSequence(@Param("schemaName") String schemaName, @Param("sequenceName") String sequenceName);

}




