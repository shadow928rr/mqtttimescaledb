package com.guo.mqtttimescaledb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.mqtttimescaledb.eneity.Controlinfo;
import com.guo.mqtttimescaledb.eneity.Measureinfo;
import com.guo.mqtttimescaledb.service.ControlinfoService;
import com.guo.mqtttimescaledb.mapper.ControlinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 57864
 * @description 针对表【controlinfo】的数据库操作Service实现
 * @createDate 2024-04-17 14:16:50
 */
@Service
public class ControlinfoServiceImpl extends ServiceImpl<ControlinfoMapper, Controlinfo>
        implements ControlinfoService {

    @Resource
    ControlinfoMapper controlinfoMapper;

    @Override
    public Controlinfo selectControlinfo(String SchemaName,String name) {
        return controlinfoMapper.selectControlinfo(SchemaName,name);
    }

    @Override
    public boolean insertControlInfoTable(String SchemaName, Controlinfo controlinfo) {
        return controlinfoMapper.insertControlInfoTable(SchemaName, controlinfo);
    }

    @Override
    public boolean updateControlInfoTable(String SchemaName, Controlinfo controlinfo) {
        return controlinfoMapper.updateControlInfoTable(SchemaName, controlinfo);
    }
}




