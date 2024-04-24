package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Containerinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.eneity.Testinfo;

import java.util.List;

/**
 * @author 57864
 * @description 针对表【containerinfo】的数据库操作Service
 * @createDate 2024-02-21 11:17:42
 */
public interface ContainerinfoService extends IService<Containerinfo> {

    List<Containerinfo> selectAll(int current, int size);

}
