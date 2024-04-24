package com.guo.mqtttimescaledb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.guo.mqtttimescaledb.eneity.Containerinfo;
import com.guo.mqtttimescaledb.eneity.Testinfo;
import com.guo.mqtttimescaledb.eneity.pageJson;
import com.guo.mqtttimescaledb.eneity.testInfoJson;
import com.guo.mqtttimescaledb.mapper.ContainerinfoMapper;
import com.guo.mqtttimescaledb.service.ContainerinfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//容器相关请求接口
public class ContainerController {

    @Autowired
    ContainerinfoService containerinfoService;

    //分页查看容器
    @CrossOrigin()
    @RequestMapping(value = "/container/selectAll", method = RequestMethod.POST)
    public String selectAllContainer(@RequestBody pageJson json) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
        List<Containerinfo> containerinfos = containerinfoService.selectAll(json.getCurrent(), json.getSize());

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode testinfoArray = objectMapper.createArrayNode();

        for (Containerinfo containerinfo : containerinfos) {
            // 将Testinfo对象转换为JSON对象
            ObjectNode containerinfoNode = objectMapper.valueToTree(containerinfo);
            testinfoArray.add(containerinfoNode);
        }

        ObjectNode result = objectMapper.createObjectNode();
        result.set("testinfos", testinfoArray);
        result.put("num", containerinfos.size());
        try {
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/container/insertContainer", method = RequestMethod.POST)
    public String insertContainer(@RequestBody Containerinfo json) {
        boolean insertSuccess = containerinfoService.save(json);
        if (insertSuccess) {
            return "插入容器成功";
        } else {
            return "插入容器失败";
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/container/deleteContainer", method = RequestMethod.POST)
    public String deleteContainer(@RequestBody Containerinfo json) {
        QueryWrapper<Containerinfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", json.getId());
        boolean deleteSuccess = containerinfoService.remove(wrapper);
        if (deleteSuccess) {
            return "删除容器成功";
        } else {
            return "删除容器失败";
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/container/editContainer", method = RequestMethod.POST)
    public String editContainer(@RequestBody Containerinfo json) {
        UpdateWrapper<Containerinfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", json.getId());
        wrapper.set("facility", json.getFacility());
        wrapper.set("position", json.getPosition());
        boolean editSuccess = containerinfoService.update(wrapper);
        if (editSuccess) {
            return "修改容器成功";
        } else {
            return "修改容器失败";
        }
    }
}
