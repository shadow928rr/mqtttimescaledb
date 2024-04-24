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
 * @TableName controlorigindata
 */
@TableName(value = "controlorigindata")
@Data
public class Controlorigindata implements Serializable {
    /**
     *
     */
    private Float current;

    /**
     *
     */
    private Integer voltage;

    /**
     *
     */
    private Integer loopid;

    /**
     *
     */
    private OffsetDateTime collecttime;

    /**
     *
     */
    private Integer num;

    /**
     *
     */
    private Float power;

    /**
     *
     */
    private String groupname;

    /**
     *
     */
    private Float calculateerror;

    /**
     *
     */
    private Float calculatecurrent;

    /**
     *
     */
    private Float calculatetemperature;

    /**
     *
     */
    private Float integralvalue;

    /**
     *
     */
    private Float derivativevalue;

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
        Controlorigindata other = (Controlorigindata) that;
        return (this.getCurrent() == null ? other.getCurrent() == null : this.getCurrent().equals(other.getCurrent()))
                && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
                && (this.getLoopid() == null ? other.getLoopid() == null : this.getLoopid().equals(other.getLoopid()))
                && (this.getCollecttime() == null ? other.getCollecttime() == null : this.getCollecttime().equals(other.getCollecttime()))
                && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
                && (this.getPower() == null ? other.getPower() == null : this.getPower().equals(other.getPower()))
                && (this.getGroupname() == null ? other.getGroupname() == null : this.getGroupname().equals(other.getGroupname()))
                && (this.getCalculateerror() == null ? other.getCalculateerror() == null : this.getCalculateerror().equals(other.getCalculateerror()))
                && (this.getCalculatecurrent() == null ? other.getCalculatecurrent() == null : this.getCalculatecurrent().equals(other.getCalculatecurrent()))
                && (this.getCalculatetemperature() == null ? other.getCalculatetemperature() == null : this.getCalculatetemperature().equals(other.getCalculatetemperature()))
                && (this.getIntegralvalue() == null ? other.getIntegralvalue() == null : this.getIntegralvalue().equals(other.getIntegralvalue()))
                && (this.getDerivativevalue() == null ? other.getDerivativevalue() == null : this.getDerivativevalue().equals(other.getDerivativevalue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCurrent() == null) ? 0 : getCurrent().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getLoopid() == null) ? 0 : getLoopid().hashCode());
        result = prime * result + ((getCollecttime() == null) ? 0 : getCollecttime().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getPower() == null) ? 0 : getPower().hashCode());
        result = prime * result + ((getGroupname() == null) ? 0 : getGroupname().hashCode());
        result = prime * result + ((getCalculateerror() == null) ? 0 : getCalculateerror().hashCode());
        result = prime * result + ((getCalculatecurrent() == null) ? 0 : getCalculatecurrent().hashCode());
        result = prime * result + ((getCalculatetemperature() == null) ? 0 : getCalculatetemperature().hashCode());
        result = prime * result + ((getIntegralvalue() == null) ? 0 : getIntegralvalue().hashCode());
        result = prime * result + ((getDerivativevalue() == null) ? 0 : getDerivativevalue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", current=").append(current);
        sb.append(", voltage=").append(voltage);
        sb.append(", loopid=").append(loopid);
        sb.append(", collecttime=").append(collecttime);
        sb.append(", num=").append(num);
        sb.append(", power=").append(power);
        sb.append(", groupname=").append(groupname);
        sb.append(", calculateerror=").append(calculateerror);
        sb.append(", calculatecurrent=").append(calculatecurrent);
        sb.append(", calculatetemperature=").append(calculatetemperature);
        sb.append(", integralvalue=").append(integralvalue);
        sb.append(", derivativevalue=").append(derivativevalue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}