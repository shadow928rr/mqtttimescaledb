package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Controlorigindata;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlorigindata】的数据库操作Service
 * @createDate 2024-04-19 13:48:07
 */
public interface ControlorigindataService extends IService<Controlorigindata> {

    //动态创建序列
    boolean createSequence(String schemaName, String sequenceName);

    //查询序列值并加一
    String selectFlagNum(String schemaName, String sequenceName);

    //动态批量插入
    boolean insertTable(@Param("schemaName") String schemaName, @Param("controlorigindataList") List<Controlorigindata> controlorigindataList);

}
