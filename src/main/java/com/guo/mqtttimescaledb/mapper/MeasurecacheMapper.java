package com.guo.mqtttimescaledb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Measurecache;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【measurecache】的数据库操作Mapper
 * @createDate 2024-01-15 09:54:33
 * @Entity com.guo.mqtttimescaledb.eneity.Measurecache
 */
public interface MeasurecacheMapper extends BaseMapper<Measurecache> {
    //动态批量插入
    boolean insertTable(@Param("schemaName") String schemaName, @Param("measurecacheList") List<Measurecache> measurecacheList);

    //删除指定模式下的measureinfo表数据
    boolean deleteAllMeasurecache(@Param("schemaName") String schemaName);
}




