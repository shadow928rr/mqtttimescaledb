package com.guo.mqtttimescaledb.eneity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class measureInfoJson {
    @JsonProperty("TestName")
    private String testname;

    @JsonProperty("ChannelInfoList")
    private List<Measureinfo> channelinfolist;
}
