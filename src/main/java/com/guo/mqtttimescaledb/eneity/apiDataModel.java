package com.guo.mqtttimescaledb.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class apiDataModel<T> {
    private int code;
    private String msg;
    private T data;
}
