package com.guo.mqtttimescaledb.Controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.guo.mqtttimescaledb.eneity.Serversize;
import com.guo.mqtttimescaledb.service.ServersizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//服务器空间大小及占用相关接口
public class ServerSizeController {
    @Autowired
    ServersizeService serversizeService;

    //查询服务器占用大小
    @RequestMapping("/serversize/selectSize")
    public Serversize selectServerSize() {
        return serversizeService.selectSize();
    }

    //前端设置空间大小
    @RequestMapping("/serversize/changeServersize/{size}")
    public Boolean changeServerSize(@PathVariable String size) {
        UpdateWrapper<Serversize> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 1);
        wrapper.set("serversize", size + "MB");
        return serversizeService.update(wrapper);
    }
}
