package com.guo.mqtttimescaledb.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttEntity implements Serializable {
    String username;
    String password;
    String hostUrl;
    String clientId;
    String topics;
}
