package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;

import lombok.Data;

/**
 * @TableName measurecache
 */
@TableName(value = "measurecache")
@Data
public class Measurecache implements Serializable {
    /**
     *
     */
    @TableId
    private int pointlabel;

    /**
     *
     */
    private OffsetDateTime maxtime4;

    /**
     *
     */
    private Float maxdata4;

    /**
     *
     */
    private OffsetDateTime minitime4;

    /**
     *
     */
    private Float minidata4;

    /**
     *
     */
    private OffsetDateTime maxtime8;

    /**
     *
     */
    private Float maxdata8;

    /**
     *
     */
    private OffsetDateTime minitime8;

    /**
     *
     */
    private Float minidata8;

    /**
     *
     */
    private OffsetDateTime maxtime16;

    /**
     *
     */
    private Float maxdata16;

    /**
     *
     */
    private OffsetDateTime minitime16;

    /**
     *
     */
    private Float minidata16;

    /**
     *
     */
    private OffsetDateTime maxtime32;

    /**
     *
     */
    private Float maxdata32;

    /**
     *
     */
    private OffsetDateTime minitime32;

    /**
     *
     */
    private Float minidata32;

    /**
     *
     */
    private OffsetDateTime maxtime64;

    /**
     *
     */
    private Float maxdata64;

    /**
     *
     */
    private OffsetDateTime minitime64;

    /**
     *
     */
    private Float minidata64;

    /**
     *
     */
    private OffsetDateTime maxtime128;

    /**
     *
     */
    private Float maxdata128;

    /**
     *
     */
    private OffsetDateTime minitime128;

    /**
     *
     */
    private Float minidata128;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointlabel=").append(pointlabel);
        sb.append(", maxtime4=").append(maxtime4);
        sb.append(", maxdata4=").append(maxdata4);
        sb.append(", minitime4=").append(minitime4);
        sb.append(", minidata4=").append(minidata4);
        sb.append(", maxtime8=").append(maxtime8);
        sb.append(", maxdata8=").append(maxdata8);
        sb.append(", minitime8=").append(minitime8);
        sb.append(", minidata8=").append(minidata8);
        sb.append(", maxtime16=").append(maxtime16);
        sb.append(", maxdata16=").append(maxdata16);
        sb.append(", minitime16=").append(minitime16);
        sb.append(", minidata16=").append(minidata16);
        sb.append(", maxtime32=").append(maxtime32);
        sb.append(", maxdata32=").append(maxdata32);
        sb.append(", minitime32=").append(minitime32);
        sb.append(", minidata32=").append(minidata32);
        sb.append(", maxtime64=").append(maxtime64);
        sb.append(", maxdata64=").append(maxdata64);
        sb.append(", minitime64=").append(minitime64);
        sb.append(", minidata64=").append(minidata64);
        sb.append(", maxtime128=").append(maxtime128);
        sb.append(", maxdata128=").append(maxdata128);
        sb.append(", minitime128=").append(minitime128);
        sb.append(", minidata128=").append(minidata128);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}