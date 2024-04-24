package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Controlcache;
import com.guo.mqtttimescaledb.service.ControlcacheService;
import com.guo.mqtttimescaledb.mapper.ControlcacheMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlcache】的数据库操作Service实现
 * @createDate 2024-04-19 14:04:58
 */
@Service
public class ControlcacheServiceImpl extends ServiceImpl<ControlcacheMapper, Controlcache>
        implements ControlcacheService {

    @Resource
    ControlcacheMapper controlcacheMapper;

    @Override
    public boolean insertTable(String schemaName, List<Controlcache> controlcacheList) {
        return controlcacheMapper.insertTable(schemaName, controlcacheList);
    }

    @Override
    public boolean deleteAllControlcache(String schemaName) {
        return controlcacheMapper.deleteAllControlcache(schemaName);
    }
}




