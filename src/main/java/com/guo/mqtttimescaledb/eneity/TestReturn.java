package com.guo.mqtttimescaledb.eneity;

import lombok.Data;

import java.util.Date;

@Data
public class TestReturn {
    /**
     * 实验名称
     */
    private String testname;

    /**
     * 模式名称
     */
    private String schemaname;

    /**
     * 总表
     */
    private String tablename;

    /**
     * 压缩表4
     */
    private String tablename4;

    /**
     * 压缩表8
     */
    private String tablename8;

    /**
     * 压缩表16
     */
    private String tablename16;

    /**
     * 压缩表32
     */
    private String tablename32;

    /**
     * 压缩表64
     */
    private String tablename64;

    /**
     * 压缩表128
     */
    private String tablename128;

    /**
     * 订阅主题
     */
    private String topic;

    /**
     * client对象
     */
    private String client;

    /**
     * 试验任务id
     */
    private String id;

    /**
     * 试验位置(方厅/部组建)
     */
    private String position;

    /**
     * 试验容器(KM3/4/6)
     */
    private String facility;

    /**
     * 开始时间
     */
    private Date begintime;
}
