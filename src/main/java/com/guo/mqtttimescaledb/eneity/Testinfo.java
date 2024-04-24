package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @TableName testinfo
 */
@TableName(value = "testinfo")
@Data
//@JsonIgnoreProperties(value = {"tablename", "tablename4", "tablename8", "tablename16", "tablename32", "tablename64", "tablename128", "id"})
public class Testinfo implements Serializable {
    /**
     * 实验名称
     */
    private String testname;

    /**
     * 模式名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String schemaname;

    /**
     * 总表
     * 动态显示
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename;

    /**
     * 压缩表4
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename4;

    /**
     * 压缩表8
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename8;

    /**
     * 压缩表16
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename16;

    /**
     * 压缩表32
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename32;

    /**
     * 压缩表64
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename64;

    /**
     * 压缩表128
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tablename128;

    /**
     * 订阅主题
     */
    private String topic;

    /**
     * client对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String client;

    /**
     * 试验任务id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    /**
     * 试验位置(方厅/部组建)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String position;

    /**
     * 试验容器(KM3/4/6)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String facility;

    /**
     * 开始时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp begintime;
    /**
     * 结束时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp endtime;
    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp createtime;
    /**
     * 试验状态
     */
    private int teststatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Testinfo other = (Testinfo) that;
        return (this.getTestname() == null ? other.getTestname() == null : this.getTestname().equals(other.getTestname()))
                && (this.getSchemaname() == null ? other.getSchemaname() == null : this.getSchemaname().equals(other.getSchemaname()))
                && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
                && (this.getTablename4() == null ? other.getTablename4() == null : this.getTablename4().equals(other.getTablename4()))
                && (this.getTablename8() == null ? other.getTablename8() == null : this.getTablename8().equals(other.getTablename8()))
                && (this.getTablename16() == null ? other.getTablename16() == null : this.getTablename16().equals(other.getTablename16()))
                && (this.getTablename32() == null ? other.getTablename32() == null : this.getTablename32().equals(other.getTablename32()))
                && (this.getTablename64() == null ? other.getTablename64() == null : this.getTablename64().equals(other.getTablename64()))
                && (this.getTablename128() == null ? other.getTablename128() == null : this.getTablename128().equals(other.getTablename128()))
                && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
                && (this.getClient() == null ? other.getClient() == null : this.getClient().equals(other.getClient()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
                && (this.getFacility() == null ? other.getFacility() == null : this.getFacility().equals(other.getFacility()))
                && (this.getBegintime() == null ? other.getBegintime() == null : this.getBegintime().equals(other.getBegintime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestname() == null) ? 0 : getTestname().hashCode());
        result = prime * result + ((getSchemaname() == null) ? 0 : getSchemaname().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getTablename4() == null) ? 0 : getTablename4().hashCode());
        result = prime * result + ((getTablename8() == null) ? 0 : getTablename8().hashCode());
        result = prime * result + ((getTablename16() == null) ? 0 : getTablename16().hashCode());
        result = prime * result + ((getTablename32() == null) ? 0 : getTablename32().hashCode());
        result = prime * result + ((getTablename64() == null) ? 0 : getTablename64().hashCode());
        result = prime * result + ((getTablename128() == null) ? 0 : getTablename128().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getClient() == null) ? 0 : getClient().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getFacility() == null) ? 0 : getFacility().hashCode());
        result = prime * result + ((getBegintime() == null) ? 0 : getBegintime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testname=").append(testname);
        sb.append(", schemaname=").append(schemaname);
        sb.append(", tablename=").append(tablename);
        sb.append(", tablename4=").append(tablename4);
        sb.append(", tablename8=").append(tablename8);
        sb.append(", tablename16=").append(tablename16);
        sb.append(", tablename32=").append(tablename32);
        sb.append(", tablename64=").append(tablename64);
        sb.append(", tablename128=").append(tablename128);
        sb.append(", topic=").append(topic);
        sb.append(", client=").append(client);
        sb.append(", id=").append(id);
        sb.append(", position=").append(position);
        sb.append(", facility=").append(facility);
        sb.append(", begintime=").append(begintime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}