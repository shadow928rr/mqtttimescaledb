package com.guo.mqtttimescaledb.mapper;

import com.guo.mqtttimescaledb.eneity.Controlorigindata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Mqtt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 57864
* @description 针对表【controlorigindata】的数据库操作Mapper
* @createDate 2024-04-19 13:48:07
* @Entity com.guo.mqtttimescaledb.eneity.Controlorigindata
*/
public interface ControlorigindataMapper extends BaseMapper<Controlorigindata> {
    //动态创建序列
    boolean createSequence(@Param("schemaName") String schemaName, @Param("sequenceName") String sequenceName);

    //查询序列值并加一
    String selectFlagNum(@Param("schemaName") String schemaName, @Param("sequenceName") String sequenceName);

    //动态批量插入
    boolean insertTable(@Param("schemaName") String schemaName, @Param("controlorigindataList") List<Controlorigindata> controlorigindataList);
}




