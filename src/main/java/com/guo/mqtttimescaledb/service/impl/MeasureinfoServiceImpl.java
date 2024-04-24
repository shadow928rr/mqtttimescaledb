package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import com.guo.mqtttimescaledb.mapper.MeasureinfoMapper;
import com.guo.mqtttimescaledb.service.MeasureinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【measureinfo】的数据库操作Service实现
 * @createDate 2024-01-03 16:11:47
 */
@Service
public class MeasureinfoServiceImpl extends ServiceImpl<MeasureinfoMapper, Measureinfo> implements MeasureinfoService {

    @Resource
    MeasureinfoMapper measureinfoMapper;

    @Override
    public boolean insertTable(String name, List<Measureinfo> measureinfoList) {
        return measureinfoMapper.insertMeasureInfoTable(name, measureinfoList);
    }

    @Override
    public boolean deleteAllMeasureinfo(String name) {
        return measureinfoMapper.deleteAllMeasureinfo(name);
    }

    @Override
    public List<Measureinfo> selectAllMeasureinfo(String SchemaName) {
        List<Measureinfo> measureinfos = measureinfoMapper.selectAllMeasureinfo(SchemaName);
        return measureinfos;
    }
}




