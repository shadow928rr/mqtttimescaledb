package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Containerinfo;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.service.ContainerinfoService;
import com.guo.mqtttimescaledb.mapper.ContainerinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【containerinfo】的数据库操作Service实现
 * @createDate 2024-02-21 11:17:42
 */
@Service
public class ContainerinfoServiceImpl extends ServiceImpl<ContainerinfoMapper, Containerinfo>
        implements ContainerinfoService {

    @Resource
    ContainerinfoMapper containerinfoMapper;

    @Override
    public List<Containerinfo> selectAll(int current, int size) {
        Page<Containerinfo> page = new Page<>(current, size);
        QueryWrapper<Containerinfo> wrapper = new QueryWrapper<>();
        wrapper.select("id", "facility", "position");
        wrapper.orderByAsc("id");
//        wrapper.like("testname",testnamekeyword);
        IPage<Containerinfo> userPage = containerinfoMapper.selectPage(page, wrapper);
        System.out.println("集合：" + userPage.getRecords());
        System.out.println("总条数：" + userPage.getTotal());
        System.out.println("当前页：" + userPage.getCurrent());
        return userPage.getRecords();
    }
}




