package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName measureinfo
 */
@TableName(value = "measureinfo")
@Data
public class Measureinfo implements Serializable {
    /**
     *
     */
    @TableId
    @JsonProperty("Index")
    private int pointlabel;

    /**
     *
     */
    @JsonProperty("PointCode")
    private String pointcode;

    /**
     *
     */
    @JsonProperty("PointDescription")
    private String pointdescription;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointindex=").append(pointlabel);
        sb.append(", pointcode=").append(pointcode);
        sb.append(", pointdescription=").append(pointdescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}