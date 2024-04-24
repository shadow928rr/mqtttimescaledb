package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.service.TestinfoService;
import com.guo.mqtttimescaledb.mapper.TestinfoMapper;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【testinfo】的数据库操作Service实现
 * @createDate 2023-12-29 14:18:40
 */
@Service
public class TestinfoServiceImpl extends ServiceImpl<TestinfoMapper, Testinfo>
        implements TestinfoService {
    @Resource
    TestinfoMapper testinfoMapper;

    @Override
    public List<Testinfo> selectTestTime(String startTime, String endTime) {
        QueryWrapper<Testinfo> wrapper = new QueryWrapper<>();
        wrapper.select("testname", "begintime", "endtime");
        wrapper.between("begintime", Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
        wrapper.or().isNull("begintime");
        return testinfoMapper.selectList(wrapper);
    }

    @Override
    public List<Testinfo> selectTest() {
        QueryWrapper<Testinfo> wrapper = new QueryWrapper<>();
        wrapper.select("testname", "begintime", "endtime", "teststatus", "topic");
        wrapper.eq("teststatus", 0).or().eq("teststatus", 1);
        return testinfoMapper.selectList(wrapper);
    }
}




