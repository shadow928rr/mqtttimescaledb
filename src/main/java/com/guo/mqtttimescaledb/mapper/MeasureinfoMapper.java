package com.guo.mqtttimescaledb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【measureinfo】的数据库操作Mapper
 * @createDate 2024-01-03 16:11:47
 * @Entity com.guo.mqtttimescaledb.eneity.Measureinfo
 */
public interface MeasureinfoMapper extends BaseMapper<Measureinfo> {
    //动态批量插入
    boolean insertMeasureInfoTable(@Param("tableName") String tableName, @Param("measureinfoList") List<Measureinfo> measureinfoList);

    //删除指定模式下的measureinfo表数据
    boolean deleteAllMeasureinfo(@Param("tableName") String tableName);

    //查询指定模式下的measureinfo表数据
    List<Measureinfo> selectAllMeasureinfo(@Param("schemaname") String SchemaName);

}




