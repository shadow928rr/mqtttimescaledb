package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @TableName mqtt
 */
@TableName(value = "mqtt")
@Data
public class Mqtt implements Serializable {

    /**
     *
     */
    private Float temperature;

    /**
     *
     */
    private Long pointlabel;

    /**
     *
     */
    private OffsetDateTime collecttime;

    /**
     *
     */
    private Long num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", temperature=").append(temperature);
        sb.append(", label=").append(pointlabel);
        sb.append(", collecttime=").append(collecttime);
        sb.append(", num=").append(num);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}