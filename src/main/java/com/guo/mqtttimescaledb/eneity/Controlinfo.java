package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @TableName controlinfo
 */
@TableName(value = "controlinfo")
@Data
public class Controlinfo implements Serializable {
    /**
     *
     */
    @TableId
    private int id;

    /**
     *
     */
    private OffsetDateTime createtime;

    /**
     *
     */
    private String content;

    /**
     *
     */
    private String name;

    private String testname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}