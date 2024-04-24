package com.guo.mqtttimescaledb.mapper;

import com.guo.mqtttimescaledb.eneity.Controlcache;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Measurecache;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlcache】的数据库操作Mapper
 * @createDate 2024-04-19 14:04:58
 * @Entity com.guo.mqtttimescaledb.eneity.Controlcache
 */
public interface ControlcacheMapper extends BaseMapper<Controlcache> {

    //动态批量插入
    boolean insertTable(@Param("schemaName") String schemaName, @Param("controlcacheList") List<Controlcache> controlcacheList);

    //删除指定模式下的measureinfo表数据
    boolean deleteAllControlcache(@Param("schemaName") String schemaName);
}




