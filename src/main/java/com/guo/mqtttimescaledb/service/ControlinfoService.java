package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Controlinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlinfo】的数据库操作Service
 * @createDate 2024-04-17 14:16:50
 */
public interface ControlinfoService extends IService<Controlinfo> {

    //查询指定模式下的 Controlinfo 表数据
    Controlinfo selectControlinfo(String SchemaName,String name);

    //插入指定模式下的 Controlinfo 表数据
    boolean insertControlInfoTable( String SchemaName,  Controlinfo controlinfo);

    //更新指定模式下的 Controlinfo 表数据
    boolean updateControlInfoTable( String SchemaName,  Controlinfo controlinfo);

}
