package com.guo.mqtttimescaledb.service;

import com.guo.mqtttimescaledb.eneity.Serversize;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guo.mqtttimescaledb.mapper.ServersizeMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author 57864
* @description 针对表【serversize】的数据库操作Service
* @createDate 2024-02-26 10:09:02
*/
public interface ServersizeService extends IService<Serversize> {
    Serversize selectSize();
}
