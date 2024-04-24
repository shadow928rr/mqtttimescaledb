package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName serversize
 */
@TableName(value ="serversize")
@Data
public class Serversize implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 设置总大小
     */
    private String serversize;

    /**
     * 已占用
     */
    private String occupationsize;

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
        Serversize other = (Serversize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServersize() == null ? other.getServersize() == null : this.getServersize().equals(other.getServersize()))
            && (this.getOccupationsize() == null ? other.getOccupationsize() == null : this.getOccupationsize().equals(other.getOccupationsize()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServersize() == null) ? 0 : getServersize().hashCode());
        result = prime * result + ((getOccupationsize() == null) ? 0 : getOccupationsize().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serversize=").append(serversize);
        sb.append(", occupationsize=").append(occupationsize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}