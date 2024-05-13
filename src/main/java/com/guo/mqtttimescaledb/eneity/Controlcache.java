package com.guo.mqtttimescaledb.eneity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @TableName controlcache
 */
@TableName(value = "controlcache")
@Data
public class Controlcache implements Serializable {
    /**
     *
     */
    @TableId
    private Integer loopid;

    /**
     *
     */
    @TableField
    private String groupname;

    /**
     *
     */
    private OffsetDateTime maxcollecttime4;

    /**
     *
     */
    private OffsetDateTime swaptime4;

    /**
     *
     */
    private OffsetDateTime mincollecttime4;

    /**
     *
     */
    private Float maxcurrent4;

    /**
     *
     */
    private Float mincurrent4;

    /**
     *
     */
    private Float maxvoltage4;

    /**
     *
     */
    private Float minvoltage4;

    /**
     *
     */
    private Float maxpower4;

    /**
     *
     */
    private Float minpower4;

    /**
     *
     */
    private Float maxcalculateerror4;

    /**
     *
     */
    private Float mincalculateerror4;

    /**
     *
     */
    private Float maxcalculatecurrent4;

    /**
     *
     */
    private Float mincalculatecurrent4;

    /**
     *
     */
    private Float maxcalculatetemperature4;

    /**
     *
     */
    private Float mincalculatetemperature4;

    /**
     *
     */
    private Float maxintegralvalue4;

    /**
     *
     */
    private Float minintegralvalue4;

    /**
     *
     */
    private Float maxderivativevalue4;

    /**
     *
     */
    private Float minderivativevalue4;

    /**
     *
     */
    private OffsetDateTime maxcollecttime8;

    /**
     *
     */
    private OffsetDateTime swaptime8;

    /**
     *
     */
    private OffsetDateTime mincollecttime8;

    /**
     *
     */
    private Float maxcurrent8;

    /**
     *
     */
    private Float mincurrent8;

    /**
     *
     */
    private Float maxvoltage8;

    /**
     *
     */
    private Float minvoltage8;

    /**
     *
     */
    private Float maxpower8;

    /**
     *
     */
    private Float minpower8;

    /**
     *
     */
    private Float maxcalculateerror8;

    /**
     *
     */
    private Float mincalculateerror8;

    /**
     *
     */
    private Float maxcalculatecurrent8;

    /**
     *
     */
    private Float mincalculatecurrent8;

    /**
     *
     */
    private Float maxcalculatetemperature8;

    /**
     *
     */
    private Float mincalculatetemperature8;

    /**
     *
     */
    private Float maxintegralvalue8;

    /**
     *
     */
    private Float minintegralvalue8;

    /**
     *
     */
    private Float maxderivativevalue8;

    /**
     *
     */
    private Float minderivativevalue8;

    /**
     *
     */
    private OffsetDateTime maxcollecttime16;

    /**
     *
     */
    private OffsetDateTime swaptime16;

    /**
     *
     */
    private OffsetDateTime mincollecttime16;

    /**
     *
     */
    private Float maxcurrent16;

    /**
     *
     */
    private Float mincurrent16;

    /**
     *
     */
    private Float maxvoltage16;

    /**
     *
     */
    private Float minvoltage16;

    /**
     *
     */
    private Float maxpower16;

    /**
     *
     */
    private Float minpower16;

    /**
     *
     */
    private Float maxcalculateerror16;

    /**
     *
     */
    private Float mincalculateerror16;

    /**
     *
     */
    private Float maxcalculatecurrent16;

    /**
     *
     */
    private Float mincalculatecurrent16;

    /**
     *
     */
    private Float maxcalculatetemperature16;

    /**
     *
     */
    private Float mincalculatetemperature16;

    /**
     *
     */
    private Float maxintegralvalue16;

    /**
     *
     */
    private Float minintegralvalue16;

    /**
     *
     */
    private Float maxderivativevalue16;

    /**
     *
     */
    private Float minderivativevalue16;

    /**
     *
     */
    private OffsetDateTime maxcollecttime32;

    /**
     *
     */
    private OffsetDateTime swaptime32;

    /**
     *
     */
    private OffsetDateTime mincollecttime32;

    /**
     *
     */
    private Float maxcurrent32;

    /**
     *
     */
    private Float mincurrent32;

    /**
     *
     */
    private Float maxvoltage32;

    /**
     *
     */
    private Float minvoltage32;

    /**
     *
     */
    private Float maxpower32;

    /**
     *
     */
    private Float minpower32;

    /**
     *
     */
    private Float maxcalculateerror32;

    /**
     *
     */
    private Float mincalculateerror32;

    /**
     *
     */
    private Float maxcalculatecurrent32;

    /**
     *
     */
    private Float mincalculatecurrent32;

    /**
     *
     */
    private Float maxcalculatetemperature32;

    /**
     *
     */
    private Float mincalculatetemperature32;

    /**
     *
     */
    private Float maxintegralvalue32;

    /**
     *
     */
    private Float minintegralvalue32;

    /**
     *
     */
    private Float maxderivativevalue32;

    /**
     *
     */
    private Float minderivativevalue32;

    /**
     *
     */
    private OffsetDateTime maxcollecttime64;

    /**
     *
     */
    private OffsetDateTime swaptime64;

    /**
     *
     */
    private OffsetDateTime mincollecttime64;

    /**
     *
     */
    private Float maxcurrent64;

    /**
     *
     */
    private Float mincurrent64;

    /**
     *
     */
    private Float maxvoltage64;

    /**
     *
     */
    private Float minvoltage64;

    /**
     *
     */
    private Float maxpower64;

    /**
     *
     */
    private Float minpower64;

    /**
     *
     */
    private Float maxcalculateerror64;

    /**
     *
     */
    private Float mincalculateerror64;

    /**
     *
     */
    private Float maxcalculatecurrent64;

    /**
     *
     */
    private Float mincalculatecurrent64;

    /**
     *
     */
    private Float maxcalculatetemperature64;

    /**
     *
     */
    private Float mincalculatetemperature64;

    /**
     *
     */
    private Float maxintegralvalue64;

    /**
     *
     */
    private Float minintegralvalue64;

    /**
     *
     */
    private Float maxderivativevalue64;

    /**
     *
     */
    private Float minderivativevalue64;

    /**
     *
     */
    private OffsetDateTime maxcollecttime128;

    /**
     *
     */
    private OffsetDateTime swaptime128;

    /**
     *
     */
    private OffsetDateTime mincollecttime128;

    /**
     *
     */
    private Float maxcurrent128;

    /**
     *
     */
    private Float mincurrent128;

    /**
     *
     */
    private Float maxvoltage128;

    /**
     *
     */
    private Float minvoltage128;

    /**
     *
     */
    private Float maxpower128;

    /**
     *
     */
    private Float minpower128;

    /**
     *
     */
    private Float maxcalculateerror128;

    /**
     *
     */
    private Float mincalculateerror128;

    /**
     *
     */
    private Float maxcalculatecurrent128;

    /**
     *
     */
    private Float mincalculatecurrent128;

    /**
     *
     */
    private Float maxcalculatetemperature128;

    /**
     *
     */
    private Float mincalculatetemperature128;

    /**
     *
     */
    private Float maxintegralvalue128;

    /**
     *
     */
    private Float minintegralvalue128;

    /**
     *
     */
    private Float maxderivativevalue128;

    /**
     *
     */
    private Float minderivativevalue128;

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
        Controlcache other = (Controlcache) that;
        return (this.getLoopid() == null ? other.getLoopid() == null : this.getLoopid().equals(other.getLoopid()))
                && (this.getGroupname() == null ? other.getGroupname() == null : this.getGroupname().equals(other.getGroupname()))
                && (this.getMaxcollecttime4() == null ? other.getMaxcollecttime4() == null : this.getMaxcollecttime4().equals(other.getMaxcollecttime4()))
                && (this.getSwaptime4() == null ? other.getSwaptime4() == null : this.getSwaptime4().equals(other.getSwaptime4()))
                && (this.getMincollecttime4() == null ? other.getMincollecttime4() == null : this.getMincollecttime4().equals(other.getMincollecttime4()))
                && (this.getMaxcurrent4() == null ? other.getMaxcurrent4() == null : this.getMaxcurrent4().equals(other.getMaxcurrent4()))
                && (this.getMincurrent4() == null ? other.getMincurrent4() == null : this.getMincurrent4().equals(other.getMincurrent4()))
                && (this.getMaxvoltage4() == null ? other.getMaxvoltage4() == null : this.getMaxvoltage4().equals(other.getMaxvoltage4()))
                && (this.getMinvoltage4() == null ? other.getMinvoltage4() == null : this.getMinvoltage4().equals(other.getMinvoltage4()))
                && (this.getMaxpower4() == null ? other.getMaxpower4() == null : this.getMaxpower4().equals(other.getMaxpower4()))
                && (this.getMinpower4() == null ? other.getMinpower4() == null : this.getMinpower4().equals(other.getMinpower4()))
                && (this.getMaxcalculateerror4() == null ? other.getMaxcalculateerror4() == null : this.getMaxcalculateerror4().equals(other.getMaxcalculateerror4()))
                && (this.getMincalculateerror4() == null ? other.getMincalculateerror4() == null : this.getMincalculateerror4().equals(other.getMincalculateerror4()))
                && (this.getMaxcalculatecurrent4() == null ? other.getMaxcalculatecurrent4() == null : this.getMaxcalculatecurrent4().equals(other.getMaxcalculatecurrent4()))
                && (this.getMincalculatecurrent4() == null ? other.getMincalculatecurrent4() == null : this.getMincalculatecurrent4().equals(other.getMincalculatecurrent4()))
                && (this.getMaxcalculatetemperature4() == null ? other.getMaxcalculatetemperature4() == null : this.getMaxcalculatetemperature4().equals(other.getMaxcalculatetemperature4()))
                && (this.getMincalculatetemperature4() == null ? other.getMincalculatetemperature4() == null : this.getMincalculatetemperature4().equals(other.getMincalculatetemperature4()))
                && (this.getMaxintegralvalue4() == null ? other.getMaxintegralvalue4() == null : this.getMaxintegralvalue4().equals(other.getMaxintegralvalue4()))
                && (this.getMinintegralvalue4() == null ? other.getMinintegralvalue4() == null : this.getMinintegralvalue4().equals(other.getMinintegralvalue4()))
                && (this.getMaxderivativevalue4() == null ? other.getMaxderivativevalue4() == null : this.getMaxderivativevalue4().equals(other.getMaxderivativevalue4()))
                && (this.getMinderivativevalue4() == null ? other.getMinderivativevalue4() == null : this.getMinderivativevalue4().equals(other.getMinderivativevalue4()))
                && (this.getMaxcollecttime8() == null ? other.getMaxcollecttime8() == null : this.getMaxcollecttime8().equals(other.getMaxcollecttime8()))
                && (this.getSwaptime8() == null ? other.getSwaptime8() == null : this.getSwaptime8().equals(other.getSwaptime8()))
                && (this.getMincollecttime8() == null ? other.getMincollecttime8() == null : this.getMincollecttime8().equals(other.getMincollecttime8()))
                && (this.getMaxcurrent8() == null ? other.getMaxcurrent8() == null : this.getMaxcurrent8().equals(other.getMaxcurrent8()))
                && (this.getMincurrent8() == null ? other.getMincurrent8() == null : this.getMincurrent8().equals(other.getMincurrent8()))
                && (this.getMaxvoltage8() == null ? other.getMaxvoltage8() == null : this.getMaxvoltage8().equals(other.getMaxvoltage8()))
                && (this.getMinvoltage8() == null ? other.getMinvoltage8() == null : this.getMinvoltage8().equals(other.getMinvoltage8()))
                && (this.getMaxpower8() == null ? other.getMaxpower8() == null : this.getMaxpower8().equals(other.getMaxpower8()))
                && (this.getMinpower8() == null ? other.getMinpower8() == null : this.getMinpower8().equals(other.getMinpower8()))
                && (this.getMaxcalculateerror8() == null ? other.getMaxcalculateerror8() == null : this.getMaxcalculateerror8().equals(other.getMaxcalculateerror8()))
                && (this.getMincalculateerror8() == null ? other.getMincalculateerror8() == null : this.getMincalculateerror8().equals(other.getMincalculateerror8()))
                && (this.getMaxcalculatecurrent8() == null ? other.getMaxcalculatecurrent8() == null : this.getMaxcalculatecurrent8().equals(other.getMaxcalculatecurrent8()))
                && (this.getMincalculatecurrent8() == null ? other.getMincalculatecurrent8() == null : this.getMincalculatecurrent8().equals(other.getMincalculatecurrent8()))
                && (this.getMaxcalculatetemperature8() == null ? other.getMaxcalculatetemperature8() == null : this.getMaxcalculatetemperature8().equals(other.getMaxcalculatetemperature8()))
                && (this.getMincalculatetemperature8() == null ? other.getMincalculatetemperature8() == null : this.getMincalculatetemperature8().equals(other.getMincalculatetemperature8()))
                && (this.getMaxintegralvalue8() == null ? other.getMaxintegralvalue8() == null : this.getMaxintegralvalue8().equals(other.getMaxintegralvalue8()))
                && (this.getMinintegralvalue8() == null ? other.getMinintegralvalue8() == null : this.getMinintegralvalue8().equals(other.getMinintegralvalue8()))
                && (this.getMaxderivativevalue8() == null ? other.getMaxderivativevalue8() == null : this.getMaxderivativevalue8().equals(other.getMaxderivativevalue8()))
                && (this.getMinderivativevalue8() == null ? other.getMinderivativevalue8() == null : this.getMinderivativevalue8().equals(other.getMinderivativevalue8()))
                && (this.getMaxcollecttime16() == null ? other.getMaxcollecttime16() == null : this.getMaxcollecttime16().equals(other.getMaxcollecttime16()))
                && (this.getSwaptime16() == null ? other.getSwaptime16() == null : this.getSwaptime16().equals(other.getSwaptime16()))
                && (this.getMincollecttime16() == null ? other.getMincollecttime16() == null : this.getMincollecttime16().equals(other.getMincollecttime16()))
                && (this.getMaxcurrent16() == null ? other.getMaxcurrent16() == null : this.getMaxcurrent16().equals(other.getMaxcurrent16()))
                && (this.getMincurrent16() == null ? other.getMincurrent16() == null : this.getMincurrent16().equals(other.getMincurrent16()))
                && (this.getMaxvoltage16() == null ? other.getMaxvoltage16() == null : this.getMaxvoltage16().equals(other.getMaxvoltage16()))
                && (this.getMinvoltage16() == null ? other.getMinvoltage16() == null : this.getMinvoltage16().equals(other.getMinvoltage16()))
                && (this.getMaxpower16() == null ? other.getMaxpower16() == null : this.getMaxpower16().equals(other.getMaxpower16()))
                && (this.getMinpower16() == null ? other.getMinpower16() == null : this.getMinpower16().equals(other.getMinpower16()))
                && (this.getMaxcalculateerror16() == null ? other.getMaxcalculateerror16() == null : this.getMaxcalculateerror16().equals(other.getMaxcalculateerror16()))
                && (this.getMincalculateerror16() == null ? other.getMincalculateerror16() == null : this.getMincalculateerror16().equals(other.getMincalculateerror16()))
                && (this.getMaxcalculatecurrent16() == null ? other.getMaxcalculatecurrent16() == null : this.getMaxcalculatecurrent16().equals(other.getMaxcalculatecurrent16()))
                && (this.getMincalculatecurrent16() == null ? other.getMincalculatecurrent16() == null : this.getMincalculatecurrent16().equals(other.getMincalculatecurrent16()))
                && (this.getMaxcalculatetemperature16() == null ? other.getMaxcalculatetemperature16() == null : this.getMaxcalculatetemperature16().equals(other.getMaxcalculatetemperature16()))
                && (this.getMincalculatetemperature16() == null ? other.getMincalculatetemperature16() == null : this.getMincalculatetemperature16().equals(other.getMincalculatetemperature16()))
                && (this.getMaxintegralvalue16() == null ? other.getMaxintegralvalue16() == null : this.getMaxintegralvalue16().equals(other.getMaxintegralvalue16()))
                && (this.getMinintegralvalue16() == null ? other.getMinintegralvalue16() == null : this.getMinintegralvalue16().equals(other.getMinintegralvalue16()))
                && (this.getMaxderivativevalue16() == null ? other.getMaxderivativevalue16() == null : this.getMaxderivativevalue16().equals(other.getMaxderivativevalue16()))
                && (this.getMinderivativevalue16() == null ? other.getMinderivativevalue16() == null : this.getMinderivativevalue16().equals(other.getMinderivativevalue16()))
                && (this.getMaxcollecttime32() == null ? other.getMaxcollecttime32() == null : this.getMaxcollecttime32().equals(other.getMaxcollecttime32()))
                && (this.getSwaptime32() == null ? other.getSwaptime32() == null : this.getSwaptime32().equals(other.getSwaptime32()))
                && (this.getMincollecttime32() == null ? other.getMincollecttime32() == null : this.getMincollecttime32().equals(other.getMincollecttime32()))
                && (this.getMaxcurrent32() == null ? other.getMaxcurrent32() == null : this.getMaxcurrent32().equals(other.getMaxcurrent32()))
                && (this.getMincurrent32() == null ? other.getMincurrent32() == null : this.getMincurrent32().equals(other.getMincurrent32()))
                && (this.getMaxvoltage32() == null ? other.getMaxvoltage32() == null : this.getMaxvoltage32().equals(other.getMaxvoltage32()))
                && (this.getMinvoltage32() == null ? other.getMinvoltage32() == null : this.getMinvoltage32().equals(other.getMinvoltage32()))
                && (this.getMaxpower32() == null ? other.getMaxpower32() == null : this.getMaxpower32().equals(other.getMaxpower32()))
                && (this.getMinpower32() == null ? other.getMinpower32() == null : this.getMinpower32().equals(other.getMinpower32()))
                && (this.getMaxcalculateerror32() == null ? other.getMaxcalculateerror32() == null : this.getMaxcalculateerror32().equals(other.getMaxcalculateerror32()))
                && (this.getMincalculateerror32() == null ? other.getMincalculateerror32() == null : this.getMincalculateerror32().equals(other.getMincalculateerror32()))
                && (this.getMaxcalculatecurrent32() == null ? other.getMaxcalculatecurrent32() == null : this.getMaxcalculatecurrent32().equals(other.getMaxcalculatecurrent32()))
                && (this.getMincalculatecurrent32() == null ? other.getMincalculatecurrent32() == null : this.getMincalculatecurrent32().equals(other.getMincalculatecurrent32()))
                && (this.getMaxcalculatetemperature32() == null ? other.getMaxcalculatetemperature32() == null : this.getMaxcalculatetemperature32().equals(other.getMaxcalculatetemperature32()))
                && (this.getMincalculatetemperature32() == null ? other.getMincalculatetemperature32() == null : this.getMincalculatetemperature32().equals(other.getMincalculatetemperature32()))
                && (this.getMaxintegralvalue32() == null ? other.getMaxintegralvalue32() == null : this.getMaxintegralvalue32().equals(other.getMaxintegralvalue32()))
                && (this.getMinintegralvalue32() == null ? other.getMinintegralvalue32() == null : this.getMinintegralvalue32().equals(other.getMinintegralvalue32()))
                && (this.getMaxderivativevalue32() == null ? other.getMaxderivativevalue32() == null : this.getMaxderivativevalue32().equals(other.getMaxderivativevalue32()))
                && (this.getMinderivativevalue32() == null ? other.getMinderivativevalue32() == null : this.getMinderivativevalue32().equals(other.getMinderivativevalue32()))
                && (this.getMaxcollecttime64() == null ? other.getMaxcollecttime64() == null : this.getMaxcollecttime64().equals(other.getMaxcollecttime64()))
                && (this.getSwaptime64() == null ? other.getSwaptime64() == null : this.getSwaptime64().equals(other.getSwaptime64()))
                && (this.getMincollecttime64() == null ? other.getMincollecttime64() == null : this.getMincollecttime64().equals(other.getMincollecttime64()))
                && (this.getMaxcurrent64() == null ? other.getMaxcurrent64() == null : this.getMaxcurrent64().equals(other.getMaxcurrent64()))
                && (this.getMincurrent64() == null ? other.getMincurrent64() == null : this.getMincurrent64().equals(other.getMincurrent64()))
                && (this.getMaxvoltage64() == null ? other.getMaxvoltage64() == null : this.getMaxvoltage64().equals(other.getMaxvoltage64()))
                && (this.getMinvoltage64() == null ? other.getMinvoltage64() == null : this.getMinvoltage64().equals(other.getMinvoltage64()))
                && (this.getMaxpower64() == null ? other.getMaxpower64() == null : this.getMaxpower64().equals(other.getMaxpower64()))
                && (this.getMinpower64() == null ? other.getMinpower64() == null : this.getMinpower64().equals(other.getMinpower64()))
                && (this.getMaxcalculateerror64() == null ? other.getMaxcalculateerror64() == null : this.getMaxcalculateerror64().equals(other.getMaxcalculateerror64()))
                && (this.getMincalculateerror64() == null ? other.getMincalculateerror64() == null : this.getMincalculateerror64().equals(other.getMincalculateerror64()))
                && (this.getMaxcalculatecurrent64() == null ? other.getMaxcalculatecurrent64() == null : this.getMaxcalculatecurrent64().equals(other.getMaxcalculatecurrent64()))
                && (this.getMincalculatecurrent64() == null ? other.getMincalculatecurrent64() == null : this.getMincalculatecurrent64().equals(other.getMincalculatecurrent64()))
                && (this.getMaxcalculatetemperature64() == null ? other.getMaxcalculatetemperature64() == null : this.getMaxcalculatetemperature64().equals(other.getMaxcalculatetemperature64()))
                && (this.getMincalculatetemperature64() == null ? other.getMincalculatetemperature64() == null : this.getMincalculatetemperature64().equals(other.getMincalculatetemperature64()))
                && (this.getMaxintegralvalue64() == null ? other.getMaxintegralvalue64() == null : this.getMaxintegralvalue64().equals(other.getMaxintegralvalue64()))
                && (this.getMinintegralvalue64() == null ? other.getMinintegralvalue64() == null : this.getMinintegralvalue64().equals(other.getMinintegralvalue64()))
                && (this.getMaxderivativevalue64() == null ? other.getMaxderivativevalue64() == null : this.getMaxderivativevalue64().equals(other.getMaxderivativevalue64()))
                && (this.getMinderivativevalue64() == null ? other.getMinderivativevalue64() == null : this.getMinderivativevalue64().equals(other.getMinderivativevalue64()))
                && (this.getMaxcollecttime128() == null ? other.getMaxcollecttime128() == null : this.getMaxcollecttime128().equals(other.getMaxcollecttime128()))
                && (this.getSwaptime128() == null ? other.getSwaptime128() == null : this.getSwaptime128().equals(other.getSwaptime128()))
                && (this.getMincollecttime128() == null ? other.getMincollecttime128() == null : this.getMincollecttime128().equals(other.getMincollecttime128()))
                && (this.getMaxcurrent128() == null ? other.getMaxcurrent128() == null : this.getMaxcurrent128().equals(other.getMaxcurrent128()))
                && (this.getMincurrent128() == null ? other.getMincurrent128() == null : this.getMincurrent128().equals(other.getMincurrent128()))
                && (this.getMaxvoltage128() == null ? other.getMaxvoltage128() == null : this.getMaxvoltage128().equals(other.getMaxvoltage128()))
                && (this.getMinvoltage128() == null ? other.getMinvoltage128() == null : this.getMinvoltage128().equals(other.getMinvoltage128()))
                && (this.getMaxpower128() == null ? other.getMaxpower128() == null : this.getMaxpower128().equals(other.getMaxpower128()))
                && (this.getMinpower128() == null ? other.getMinpower128() == null : this.getMinpower128().equals(other.getMinpower128()))
                && (this.getMaxcalculateerror128() == null ? other.getMaxcalculateerror128() == null : this.getMaxcalculateerror128().equals(other.getMaxcalculateerror128()))
                && (this.getMincalculateerror128() == null ? other.getMincalculateerror128() == null : this.getMincalculateerror128().equals(other.getMincalculateerror128()))
                && (this.getMaxcalculatecurrent128() == null ? other.getMaxcalculatecurrent128() == null : this.getMaxcalculatecurrent128().equals(other.getMaxcalculatecurrent128()))
                && (this.getMincalculatecurrent128() == null ? other.getMincalculatecurrent128() == null : this.getMincalculatecurrent128().equals(other.getMincalculatecurrent128()))
                && (this.getMaxcalculatetemperature128() == null ? other.getMaxcalculatetemperature128() == null : this.getMaxcalculatetemperature128().equals(other.getMaxcalculatetemperature128()))
                && (this.getMincalculatetemperature128() == null ? other.getMincalculatetemperature128() == null : this.getMincalculatetemperature128().equals(other.getMincalculatetemperature128()))
                && (this.getMaxintegralvalue128() == null ? other.getMaxintegralvalue128() == null : this.getMaxintegralvalue128().equals(other.getMaxintegralvalue128()))
                && (this.getMinintegralvalue128() == null ? other.getMinintegralvalue128() == null : this.getMinintegralvalue128().equals(other.getMinintegralvalue128()))
                && (this.getMaxderivativevalue128() == null ? other.getMaxderivativevalue128() == null : this.getMaxderivativevalue128().equals(other.getMaxderivativevalue128()))
                && (this.getMinderivativevalue128() == null ? other.getMinderivativevalue128() == null : this.getMinderivativevalue128().equals(other.getMinderivativevalue128()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoopid() == null) ? 0 : getLoopid().hashCode());
        result = prime * result + ((getGroupname() == null) ? 0 : getGroupname().hashCode());
        result = prime * result + ((getMaxcollecttime4() == null) ? 0 : getMaxcollecttime4().hashCode());
        result = prime * result + ((getSwaptime4() == null) ? 0 : getSwaptime4().hashCode());
        result = prime * result + ((getMincollecttime4() == null) ? 0 : getMincollecttime4().hashCode());
        result = prime * result + ((getMaxcurrent4() == null) ? 0 : getMaxcurrent4().hashCode());
        result = prime * result + ((getMincurrent4() == null) ? 0 : getMincurrent4().hashCode());
        result = prime * result + ((getMaxvoltage4() == null) ? 0 : getMaxvoltage4().hashCode());
        result = prime * result + ((getMinvoltage4() == null) ? 0 : getMinvoltage4().hashCode());
        result = prime * result + ((getMaxpower4() == null) ? 0 : getMaxpower4().hashCode());
        result = prime * result + ((getMinpower4() == null) ? 0 : getMinpower4().hashCode());
        result = prime * result + ((getMaxcalculateerror4() == null) ? 0 : getMaxcalculateerror4().hashCode());
        result = prime * result + ((getMincalculateerror4() == null) ? 0 : getMincalculateerror4().hashCode());
        result = prime * result + ((getMaxcalculatecurrent4() == null) ? 0 : getMaxcalculatecurrent4().hashCode());
        result = prime * result + ((getMincalculatecurrent4() == null) ? 0 : getMincalculatecurrent4().hashCode());
        result = prime * result + ((getMaxcalculatetemperature4() == null) ? 0 : getMaxcalculatetemperature4().hashCode());
        result = prime * result + ((getMincalculatetemperature4() == null) ? 0 : getMincalculatetemperature4().hashCode());
        result = prime * result + ((getMaxintegralvalue4() == null) ? 0 : getMaxintegralvalue4().hashCode());
        result = prime * result + ((getMinintegralvalue4() == null) ? 0 : getMinintegralvalue4().hashCode());
        result = prime * result + ((getMaxderivativevalue4() == null) ? 0 : getMaxderivativevalue4().hashCode());
        result = prime * result + ((getMinderivativevalue4() == null) ? 0 : getMinderivativevalue4().hashCode());
        result = prime * result + ((getMaxcollecttime8() == null) ? 0 : getMaxcollecttime8().hashCode());
        result = prime * result + ((getSwaptime8() == null) ? 0 : getSwaptime8().hashCode());
        result = prime * result + ((getMincollecttime8() == null) ? 0 : getMincollecttime8().hashCode());
        result = prime * result + ((getMaxcurrent8() == null) ? 0 : getMaxcurrent8().hashCode());
        result = prime * result + ((getMincurrent8() == null) ? 0 : getMincurrent8().hashCode());
        result = prime * result + ((getMaxvoltage8() == null) ? 0 : getMaxvoltage8().hashCode());
        result = prime * result + ((getMinvoltage8() == null) ? 0 : getMinvoltage8().hashCode());
        result = prime * result + ((getMaxpower8() == null) ? 0 : getMaxpower8().hashCode());
        result = prime * result + ((getMinpower8() == null) ? 0 : getMinpower8().hashCode());
        result = prime * result + ((getMaxcalculateerror8() == null) ? 0 : getMaxcalculateerror8().hashCode());
        result = prime * result + ((getMincalculateerror8() == null) ? 0 : getMincalculateerror8().hashCode());
        result = prime * result + ((getMaxcalculatecurrent8() == null) ? 0 : getMaxcalculatecurrent8().hashCode());
        result = prime * result + ((getMincalculatecurrent8() == null) ? 0 : getMincalculatecurrent8().hashCode());
        result = prime * result + ((getMaxcalculatetemperature8() == null) ? 0 : getMaxcalculatetemperature8().hashCode());
        result = prime * result + ((getMincalculatetemperature8() == null) ? 0 : getMincalculatetemperature8().hashCode());
        result = prime * result + ((getMaxintegralvalue8() == null) ? 0 : getMaxintegralvalue8().hashCode());
        result = prime * result + ((getMinintegralvalue8() == null) ? 0 : getMinintegralvalue8().hashCode());
        result = prime * result + ((getMaxderivativevalue8() == null) ? 0 : getMaxderivativevalue8().hashCode());
        result = prime * result + ((getMinderivativevalue8() == null) ? 0 : getMinderivativevalue8().hashCode());
        result = prime * result + ((getMaxcollecttime16() == null) ? 0 : getMaxcollecttime16().hashCode());
        result = prime * result + ((getSwaptime16() == null) ? 0 : getSwaptime16().hashCode());
        result = prime * result + ((getMincollecttime16() == null) ? 0 : getMincollecttime16().hashCode());
        result = prime * result + ((getMaxcurrent16() == null) ? 0 : getMaxcurrent16().hashCode());
        result = prime * result + ((getMincurrent16() == null) ? 0 : getMincurrent16().hashCode());
        result = prime * result + ((getMaxvoltage16() == null) ? 0 : getMaxvoltage16().hashCode());
        result = prime * result + ((getMinvoltage16() == null) ? 0 : getMinvoltage16().hashCode());
        result = prime * result + ((getMaxpower16() == null) ? 0 : getMaxpower16().hashCode());
        result = prime * result + ((getMinpower16() == null) ? 0 : getMinpower16().hashCode());
        result = prime * result + ((getMaxcalculateerror16() == null) ? 0 : getMaxcalculateerror16().hashCode());
        result = prime * result + ((getMincalculateerror16() == null) ? 0 : getMincalculateerror16().hashCode());
        result = prime * result + ((getMaxcalculatecurrent16() == null) ? 0 : getMaxcalculatecurrent16().hashCode());
        result = prime * result + ((getMincalculatecurrent16() == null) ? 0 : getMincalculatecurrent16().hashCode());
        result = prime * result + ((getMaxcalculatetemperature16() == null) ? 0 : getMaxcalculatetemperature16().hashCode());
        result = prime * result + ((getMincalculatetemperature16() == null) ? 0 : getMincalculatetemperature16().hashCode());
        result = prime * result + ((getMaxintegralvalue16() == null) ? 0 : getMaxintegralvalue16().hashCode());
        result = prime * result + ((getMinintegralvalue16() == null) ? 0 : getMinintegralvalue16().hashCode());
        result = prime * result + ((getMaxderivativevalue16() == null) ? 0 : getMaxderivativevalue16().hashCode());
        result = prime * result + ((getMinderivativevalue16() == null) ? 0 : getMinderivativevalue16().hashCode());
        result = prime * result + ((getMaxcollecttime32() == null) ? 0 : getMaxcollecttime32().hashCode());
        result = prime * result + ((getSwaptime32() == null) ? 0 : getSwaptime32().hashCode());
        result = prime * result + ((getMincollecttime32() == null) ? 0 : getMincollecttime32().hashCode());
        result = prime * result + ((getMaxcurrent32() == null) ? 0 : getMaxcurrent32().hashCode());
        result = prime * result + ((getMincurrent32() == null) ? 0 : getMincurrent32().hashCode());
        result = prime * result + ((getMaxvoltage32() == null) ? 0 : getMaxvoltage32().hashCode());
        result = prime * result + ((getMinvoltage32() == null) ? 0 : getMinvoltage32().hashCode());
        result = prime * result + ((getMaxpower32() == null) ? 0 : getMaxpower32().hashCode());
        result = prime * result + ((getMinpower32() == null) ? 0 : getMinpower32().hashCode());
        result = prime * result + ((getMaxcalculateerror32() == null) ? 0 : getMaxcalculateerror32().hashCode());
        result = prime * result + ((getMincalculateerror32() == null) ? 0 : getMincalculateerror32().hashCode());
        result = prime * result + ((getMaxcalculatecurrent32() == null) ? 0 : getMaxcalculatecurrent32().hashCode());
        result = prime * result + ((getMincalculatecurrent32() == null) ? 0 : getMincalculatecurrent32().hashCode());
        result = prime * result + ((getMaxcalculatetemperature32() == null) ? 0 : getMaxcalculatetemperature32().hashCode());
        result = prime * result + ((getMincalculatetemperature32() == null) ? 0 : getMincalculatetemperature32().hashCode());
        result = prime * result + ((getMaxintegralvalue32() == null) ? 0 : getMaxintegralvalue32().hashCode());
        result = prime * result + ((getMinintegralvalue32() == null) ? 0 : getMinintegralvalue32().hashCode());
        result = prime * result + ((getMaxderivativevalue32() == null) ? 0 : getMaxderivativevalue32().hashCode());
        result = prime * result + ((getMinderivativevalue32() == null) ? 0 : getMinderivativevalue32().hashCode());
        result = prime * result + ((getMaxcollecttime64() == null) ? 0 : getMaxcollecttime64().hashCode());
        result = prime * result + ((getSwaptime64() == null) ? 0 : getSwaptime64().hashCode());
        result = prime * result + ((getMincollecttime64() == null) ? 0 : getMincollecttime64().hashCode());
        result = prime * result + ((getMaxcurrent64() == null) ? 0 : getMaxcurrent64().hashCode());
        result = prime * result + ((getMincurrent64() == null) ? 0 : getMincurrent64().hashCode());
        result = prime * result + ((getMaxvoltage64() == null) ? 0 : getMaxvoltage64().hashCode());
        result = prime * result + ((getMinvoltage64() == null) ? 0 : getMinvoltage64().hashCode());
        result = prime * result + ((getMaxpower64() == null) ? 0 : getMaxpower64().hashCode());
        result = prime * result + ((getMinpower64() == null) ? 0 : getMinpower64().hashCode());
        result = prime * result + ((getMaxcalculateerror64() == null) ? 0 : getMaxcalculateerror64().hashCode());
        result = prime * result + ((getMincalculateerror64() == null) ? 0 : getMincalculateerror64().hashCode());
        result = prime * result + ((getMaxcalculatecurrent64() == null) ? 0 : getMaxcalculatecurrent64().hashCode());
        result = prime * result + ((getMincalculatecurrent64() == null) ? 0 : getMincalculatecurrent64().hashCode());
        result = prime * result + ((getMaxcalculatetemperature64() == null) ? 0 : getMaxcalculatetemperature64().hashCode());
        result = prime * result + ((getMincalculatetemperature64() == null) ? 0 : getMincalculatetemperature64().hashCode());
        result = prime * result + ((getMaxintegralvalue64() == null) ? 0 : getMaxintegralvalue64().hashCode());
        result = prime * result + ((getMinintegralvalue64() == null) ? 0 : getMinintegralvalue64().hashCode());
        result = prime * result + ((getMaxderivativevalue64() == null) ? 0 : getMaxderivativevalue64().hashCode());
        result = prime * result + ((getMinderivativevalue64() == null) ? 0 : getMinderivativevalue64().hashCode());
        result = prime * result + ((getMaxcollecttime128() == null) ? 0 : getMaxcollecttime128().hashCode());
        result = prime * result + ((getSwaptime128() == null) ? 0 : getSwaptime128().hashCode());
        result = prime * result + ((getMincollecttime128() == null) ? 0 : getMincollecttime128().hashCode());
        result = prime * result + ((getMaxcurrent128() == null) ? 0 : getMaxcurrent128().hashCode());
        result = prime * result + ((getMincurrent128() == null) ? 0 : getMincurrent128().hashCode());
        result = prime * result + ((getMaxvoltage128() == null) ? 0 : getMaxvoltage128().hashCode());
        result = prime * result + ((getMinvoltage128() == null) ? 0 : getMinvoltage128().hashCode());
        result = prime * result + ((getMaxpower128() == null) ? 0 : getMaxpower128().hashCode());
        result = prime * result + ((getMinpower128() == null) ? 0 : getMinpower128().hashCode());
        result = prime * result + ((getMaxcalculateerror128() == null) ? 0 : getMaxcalculateerror128().hashCode());
        result = prime * result + ((getMincalculateerror128() == null) ? 0 : getMincalculateerror128().hashCode());
        result = prime * result + ((getMaxcalculatecurrent128() == null) ? 0 : getMaxcalculatecurrent128().hashCode());
        result = prime * result + ((getMincalculatecurrent128() == null) ? 0 : getMincalculatecurrent128().hashCode());
        result = prime * result + ((getMaxcalculatetemperature128() == null) ? 0 : getMaxcalculatetemperature128().hashCode());
        result = prime * result + ((getMincalculatetemperature128() == null) ? 0 : getMincalculatetemperature128().hashCode());
        result = prime * result + ((getMaxintegralvalue128() == null) ? 0 : getMaxintegralvalue128().hashCode());
        result = prime * result + ((getMinintegralvalue128() == null) ? 0 : getMinintegralvalue128().hashCode());
        result = prime * result + ((getMaxderivativevalue128() == null) ? 0 : getMaxderivativevalue128().hashCode());
        result = prime * result + ((getMinderivativevalue128() == null) ? 0 : getMinderivativevalue128().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loopid=").append(loopid);
        sb.append(", groupname=").append(groupname);
        sb.append(", maxcollecttime4=").append(maxcollecttime4);
        sb.append(", swaptime4=").append(swaptime4);
        sb.append(", mincollecttime4=").append(mincollecttime4);
        sb.append(", maxcurrent4=").append(maxcurrent4);
        sb.append(", mincurrent4=").append(mincurrent4);
        sb.append(", maxvoltage4=").append(maxvoltage4);
        sb.append(", minvoltage4=").append(minvoltage4);
        sb.append(", maxpower4=").append(maxpower4);
        sb.append(", minpower4=").append(minpower4);
        sb.append(", maxcalculateerror4=").append(maxcalculateerror4);
        sb.append(", mincalculateerror4=").append(mincalculateerror4);
        sb.append(", maxcalculatecurrent4=").append(maxcalculatecurrent4);
        sb.append(", mincalculatecurrent4=").append(mincalculatecurrent4);
        sb.append(", maxcalculatetemperature4=").append(maxcalculatetemperature4);
        sb.append(", mincalculatetemperature4=").append(mincalculatetemperature4);
        sb.append(", maxintegralvalue4=").append(maxintegralvalue4);
        sb.append(", minintegralvalue4=").append(minintegralvalue4);
        sb.append(", maxderivativevalue4=").append(maxderivativevalue4);
        sb.append(", minderivativevalue4=").append(minderivativevalue4);
        sb.append(", maxcollecttime8=").append(maxcollecttime8);
        sb.append(", swaptime8=").append(swaptime8);
        sb.append(", mincollecttime8=").append(mincollecttime8);
        sb.append(", maxcurrent8=").append(maxcurrent8);
        sb.append(", mincurrent8=").append(mincurrent8);
        sb.append(", maxvoltage8=").append(maxvoltage8);
        sb.append(", minvoltage8=").append(minvoltage8);
        sb.append(", maxpower8=").append(maxpower8);
        sb.append(", minpower8=").append(minpower8);
        sb.append(", maxcalculateerror8=").append(maxcalculateerror8);
        sb.append(", mincalculateerror8=").append(mincalculateerror8);
        sb.append(", maxcalculatecurrent8=").append(maxcalculatecurrent8);
        sb.append(", mincalculatecurrent8=").append(mincalculatecurrent8);
        sb.append(", maxcalculatetemperature8=").append(maxcalculatetemperature8);
        sb.append(", mincalculatetemperature8=").append(mincalculatetemperature8);
        sb.append(", maxintegralvalue8=").append(maxintegralvalue8);
        sb.append(", minintegralvalue8=").append(minintegralvalue8);
        sb.append(", maxderivativevalue8=").append(maxderivativevalue8);
        sb.append(", minderivativevalue8=").append(minderivativevalue8);
        sb.append(", maxcollecttime16=").append(maxcollecttime16);
        sb.append(", swaptime16=").append(swaptime16);
        sb.append(", mincollecttime16=").append(mincollecttime16);
        sb.append(", maxcurrent16=").append(maxcurrent16);
        sb.append(", mincurrent16=").append(mincurrent16);
        sb.append(", maxvoltage16=").append(maxvoltage16);
        sb.append(", minvoltage16=").append(minvoltage16);
        sb.append(", maxpower16=").append(maxpower16);
        sb.append(", minpower16=").append(minpower16);
        sb.append(", maxcalculateerror16=").append(maxcalculateerror16);
        sb.append(", mincalculateerror16=").append(mincalculateerror16);
        sb.append(", maxcalculatecurrent16=").append(maxcalculatecurrent16);
        sb.append(", mincalculatecurrent16=").append(mincalculatecurrent16);
        sb.append(", maxcalculatetemperature16=").append(maxcalculatetemperature16);
        sb.append(", mincalculatetemperature16=").append(mincalculatetemperature16);
        sb.append(", maxintegralvalue16=").append(maxintegralvalue16);
        sb.append(", minintegralvalue16=").append(minintegralvalue16);
        sb.append(", maxderivativevalue16=").append(maxderivativevalue16);
        sb.append(", minderivativevalue16=").append(minderivativevalue16);
        sb.append(", maxcollecttime32=").append(maxcollecttime32);
        sb.append(", swaptime32=").append(swaptime32);
        sb.append(", mincollecttime32=").append(mincollecttime32);
        sb.append(", maxcurrent32=").append(maxcurrent32);
        sb.append(", mincurrent32=").append(mincurrent32);
        sb.append(", maxvoltage32=").append(maxvoltage32);
        sb.append(", minvoltage32=").append(minvoltage32);
        sb.append(", maxpower32=").append(maxpower32);
        sb.append(", minpower32=").append(minpower32);
        sb.append(", maxcalculateerror32=").append(maxcalculateerror32);
        sb.append(", mincalculateerror32=").append(mincalculateerror32);
        sb.append(", maxcalculatecurrent32=").append(maxcalculatecurrent32);
        sb.append(", mincalculatecurrent32=").append(mincalculatecurrent32);
        sb.append(", maxcalculatetemperature32=").append(maxcalculatetemperature32);
        sb.append(", mincalculatetemperature32=").append(mincalculatetemperature32);
        sb.append(", maxintegralvalue32=").append(maxintegralvalue32);
        sb.append(", minintegralvalue32=").append(minintegralvalue32);
        sb.append(", maxderivativevalue32=").append(maxderivativevalue32);
        sb.append(", minderivativevalue32=").append(minderivativevalue32);
        sb.append(", maxcollecttime64=").append(maxcollecttime64);
        sb.append(", swaptime64=").append(swaptime64);
        sb.append(", mincollecttime64=").append(mincollecttime64);
        sb.append(", maxcurrent64=").append(maxcurrent64);
        sb.append(", mincurrent64=").append(mincurrent64);
        sb.append(", maxvoltage64=").append(maxvoltage64);
        sb.append(", minvoltage64=").append(minvoltage64);
        sb.append(", maxpower64=").append(maxpower64);
        sb.append(", minpower64=").append(minpower64);
        sb.append(", maxcalculateerror64=").append(maxcalculateerror64);
        sb.append(", mincalculateerror64=").append(mincalculateerror64);
        sb.append(", maxcalculatecurrent64=").append(maxcalculatecurrent64);
        sb.append(", mincalculatecurrent64=").append(mincalculatecurrent64);
        sb.append(", maxcalculatetemperature64=").append(maxcalculatetemperature64);
        sb.append(", mincalculatetemperature64=").append(mincalculatetemperature64);
        sb.append(", maxintegralvalue64=").append(maxintegralvalue64);
        sb.append(", minintegralvalue64=").append(minintegralvalue64);
        sb.append(", maxderivativevalue64=").append(maxderivativevalue64);
        sb.append(", minderivativevalue64=").append(minderivativevalue64);
        sb.append(", maxcollecttime128=").append(maxcollecttime128);
        sb.append(", swaptime128=").append(swaptime128);
        sb.append(", mincollecttime128=").append(mincollecttime128);
        sb.append(", maxcurrent128=").append(maxcurrent128);
        sb.append(", mincurrent128=").append(mincurrent128);
        sb.append(", maxvoltage128=").append(maxvoltage128);
        sb.append(", minvoltage128=").append(minvoltage128);
        sb.append(", maxpower128=").append(maxpower128);
        sb.append(", minpower128=").append(minpower128);
        sb.append(", maxcalculateerror128=").append(maxcalculateerror128);
        sb.append(", mincalculateerror128=").append(mincalculateerror128);
        sb.append(", maxcalculatecurrent128=").append(maxcalculatecurrent128);
        sb.append(", mincalculatecurrent128=").append(mincalculatecurrent128);
        sb.append(", maxcalculatetemperature128=").append(maxcalculatetemperature128);
        sb.append(", mincalculatetemperature128=").append(mincalculatetemperature128);
        sb.append(", maxintegralvalue128=").append(maxintegralvalue128);
        sb.append(", minintegralvalue128=").append(minintegralvalue128);
        sb.append(", maxderivativevalue128=").append(maxderivativevalue128);
        sb.append(", minderivativevalue128=").append(minderivativevalue128);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}