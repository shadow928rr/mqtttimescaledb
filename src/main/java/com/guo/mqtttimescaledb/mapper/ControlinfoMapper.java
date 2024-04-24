package com.guo.mqtttimescaledb.mapper;

import com.guo.mqtttimescaledb.eneity.Controlinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlinfo】的数据库操作Mapper
 * @createDate 2024-04-17 14:16:50
 * @Entity com.guo.mqtttimescaledb.eneity.Controlinfo
 */
public interface ControlinfoMapper extends BaseMapper<Controlinfo> {

    //查询指定模式下的 Controlinfo 表数据
    Controlinfo selectControlinfo(@Param("schemaname") String SchemaName, @Param("name") String name);

    //查询指定模式下的 Controlinfo 表数据
//    boolean insertControlInfoTable(@Param("schemaname") String SchemaName, @Param("measureinfoList") List<Controlinfo> controlinfoList);
    boolean insertControlInfoTable(@Param("schemaname") String SchemaName, @Param("controlinfo") Controlinfo controlinfo);

    //更新指定模式下的 Controlinfo 表数据
    boolean updateControlInfoTable(@Param("schemaname") String SchemaName, @Param("controlinfo") Controlinfo controlinfo);
}




