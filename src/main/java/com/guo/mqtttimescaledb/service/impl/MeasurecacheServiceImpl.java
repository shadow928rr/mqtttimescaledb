package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Measurecache;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import com.guo.mqtttimescaledb.mapper.MeasurecacheMapper;
import com.guo.mqtttimescaledb.service.MeasurecacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【measurecache】的数据库操作Service实现
 * @createDate 2024-01-15 09:54:33
 */
@Service
public class MeasurecacheServiceImpl extends ServiceImpl<MeasurecacheMapper, Measurecache>
        implements MeasurecacheService {

    @Resource
    MeasurecacheMapper measurecacheMapper;

    @Override
    public boolean deleteAllMeasurecache(String name) {
        return measurecacheMapper.deleteAllMeasurecache(name);
    }

    @Override
    public boolean insertTable(String name, List<Measurecache> measurecacheList) {
        return measurecacheMapper.insertTable(name, measurecacheList);
    }
}




