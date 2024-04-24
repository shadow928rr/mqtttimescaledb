package com.guo.mqtttimescaledb.mapper;

import com.guo.mqtttimescaledb.eneity.Serversize;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author 57864
 * @description 针对表【serversize】的数据库操作Mapper
 * @createDate 2024-02-26 10:09:02
 * @Entity com.guo.mqtttimescaledb.eneity.Serversize
 */
public interface ServersizeMapper extends BaseMapper<Serversize> {
    //查询服务器占用大小
    String selectServerOccupationSize();
}




