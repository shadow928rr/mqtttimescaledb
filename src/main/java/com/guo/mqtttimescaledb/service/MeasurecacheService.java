package com.guo.mqtttimescaledb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.eneity.Measurecache;
import com.guo.mqtttimescaledb.eneity.Measureinfo;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【measurecache】的数据库操作Service
 * @createDate 2024-01-15 09:54:33
 */
public interface MeasurecacheService extends IService<Measurecache> {
    //动态插入
    boolean insertTable(String name, List<Measurecache> measurecacheList);//动态插入

    boolean deleteAllMeasurecache(String name);

}
