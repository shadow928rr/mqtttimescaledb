package com.guo.mqtttimescaledb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.eneity.Measureinfo;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【measureinfo】的数据库操作Service
 * @createDate 2024-01-03 16:11:47
 */
public interface MeasureinfoService extends IService<Measureinfo> {

    //动态插入
    boolean insertTable(String name, List<Measureinfo> measureinfoList);//动态插入

    boolean deleteAllMeasureinfo(String name);

    List<Measureinfo> selectAllMeasureinfo(String name);
}
