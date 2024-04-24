package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【testinfo】的数据库操作Service
 * @createDate 2023-12-29 14:18:40
 */
public interface TestinfoService extends IService<Testinfo> {

    //查询试验的运行时间多少h
    List<Testinfo> selectTestTime(String startTime, String endTime);
    //查询试验运行时间和未开始试验
    List<Testinfo> selectTest();
}
