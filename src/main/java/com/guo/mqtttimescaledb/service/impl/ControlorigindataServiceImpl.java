package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Controlorigindata;
import com.guo.mqtttimescaledb.service.ControlorigindataService;
import com.guo.mqtttimescaledb.mapper.ControlorigindataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlorigindata】的数据库操作Service实现
 * @createDate 2024-04-19 13:48:07
 */
@Service
public class ControlorigindataServiceImpl extends ServiceImpl<ControlorigindataMapper, Controlorigindata>
        implements ControlorigindataService {
    @Resource
    ControlorigindataMapper controlorigindataMapper;

    @Override
    public boolean createSequence(String schemaName, String sequenceName) {
        return controlorigindataMapper.createSequence(schemaName, sequenceName);
    }

    @Override
    public String selectFlagNum(String schemaName, String sequenceName) {
        return controlorigindataMapper.selectFlagNum(schemaName, sequenceName);
    }

    @Override
    public boolean insertTable(String schemaName, List<Controlorigindata> controlorigindataList) {
        return controlorigindataMapper.insertTable(schemaName, controlorigindataList);
    }
}




