package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Controlcache;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlcache】的数据库操作Service
 * @createDate 2024-04-19 14:04:58
 */
public interface ControlcacheService extends IService<Controlcache> {

    //动态批量插入
    boolean insertTable(String schemaName, List<Controlcache> controlcacheList);

    //删除指定模式下的measureinfo表数据
    boolean deleteAllControlcache(String schemaName);
}
