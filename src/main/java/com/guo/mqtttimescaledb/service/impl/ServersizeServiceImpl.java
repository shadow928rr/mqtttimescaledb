package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Serversize;
import com.guo.mqtttimescaledb.mapper.MqttMapper;
import com.guo.mqtttimescaledb.service.ServersizeService;
import com.guo.mqtttimescaledb.mapper.ServersizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 57864
 * @description 针对表【serversize】的数据库操作Service实现
 * @createDate 2024-02-26 10:09:02
 */
@Service
public class ServersizeServiceImpl extends ServiceImpl<ServersizeMapper, Serversize>
        implements ServersizeService {
    @Resource
    ServersizeMapper serversizeMapper;

    @Override
    public Serversize selectSize() {
        QueryWrapper<Serversize> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        Serversize serversize = serversizeMapper.selectOne(wrapper);
        serversize.setOccupationsize(serversizeMapper.selectServerOccupationSize().replaceAll(" ", ""));
        return serversize;
    }
}




