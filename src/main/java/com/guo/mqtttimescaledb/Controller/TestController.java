package com.guo.mqtttimescaledb.Controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.guo.mqtttimescaledb.config.MqttConsumerConfig;
import com.guo.mqtttimescaledb.eneity.*;
import com.guo.mqtttimescaledb.mapper.ControlinfoMapper;
import com.guo.mqtttimescaledb.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
//试验相关请求接口
public class TestController {
    @Autowired
    private MqttConsumerConfig mqttconfig;
    @Autowired
    private MqttService mqttService;
    @Autowired
    private MeasureinfoService measureinfoService;
    @Autowired
    private MeasurecacheService measurecacheService;
    @Autowired
    private TestinfoService testinfoService;
    @Autowired
    private ControlinfoService controlinfoService;
    @Autowired
    private ControlorigindataService controlorigindataService;
    @Autowired
    private ControlcacheService controlcacheService;

//    @Value("${spring.mqtt.client.id}")
//    private String clientId;

//    @RequestMapping("/connect")
//    public String connect() {
//        mqttconfig.connect();
//        return clientId + "连接到服务器";
//    }

    //连接的时候接收body中的配置json落库，判断body中是否有数据，判断数据库中是否已经落库了
    @RequestMapping("/connect/{topicName}")
    public String connect(@PathVariable String topicName) {
        UpdateWrapper<Testinfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("topic", topicName);
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        wrapper.set("begintime", currentDateTime);
        wrapper.set("teststatus", 1);
        testinfoService.update(wrapper);
        boolean connect = mqttconfig.connect(topicName);
        if (connect) {
            return topicName + "连接到服务器";
        } else {
            return topicName + "连接失败";
        }
    }

    //变更connect接口，连接mqtt及落库配置json
    @CrossOrigin()
    @RequestMapping(value = "/StartMeasure", method = RequestMethod.POST)
    @Transactional
    public apiDataModel<Object> StartMeasure(@RequestBody measureInfoJson measureInfoJson) {
        System.out.println(measureInfoJson);
        //删除measureinfo表数据，正常情况是清除原有测点，更换测点的数量
        boolean delMeasureinfo = measureinfoService.deleteAllMeasureinfo(measureInfoJson.getTestname());
        //删除measurecache表数据，正常情况是清除原有测点缓存值及时间，更换测点的数量
        boolean delMeasurecache = measurecacheService.deleteAllMeasurecache(measureInfoJson.getTestname());
        boolean insertMeasureinfo = measureinfoService.insertTable(measureInfoJson.getTestname(), measureInfoJson.getChannelinfolist());
        List<Measurecache> measurecacheList = new ArrayList<>();

        for (int i = 1; i <= measureInfoJson.getChannelinfolist().size(); i++) {
            Measurecache measurecache = new Measurecache();
            measurecache.setPointlabel(i);
            measurecacheList.add(measurecache);
        }
        boolean insertMeasurecache = measurecacheService.insertTable(measureInfoJson.getTestname(), measurecacheList);
//        boolean connect = mqttconfig.connect(measureInfoJson.getTestname());
//        if (connect && insertMeasureinfo && delMeasureinfo && delMeasurecache && insertMeasurecache) {
        if (insertMeasureinfo && delMeasureinfo && delMeasurecache && insertMeasurecache) {
            return new apiDataModel<>(200, "success", measureInfoJson.getTestname() + "配置成功");
        } else {
            return new apiDataModel<>(404, "false", measureInfoJson.getTestname() + "配置失败");
        }
//        return new apiDataModel<>(200, "success", measureInfoJson);
//        boolean connect = mqttconfig.connect(json);
//        if (connect) {
//            return json + "连接到服务器";
//        } else {
//            return json + "连接失败";
//        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/StartControl", method = RequestMethod.POST)
    @Transactional
    public apiDataModel<Object> StartControl(@RequestBody String controlInfoJson) {
//        System.out.println(controlInfoJson);
//        查询是否已存在，不存在插入存在更新
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(controlInfoJson);
            Controlinfo selectControlinfo = controlinfoService.selectControlinfo(jsonNode.get("TestName").asText(), jsonNode.get("DataHeaderName").asText());

            Controlinfo controlinfo = new Controlinfo();
            controlinfo.setCreatetime(OffsetDateTime.parse(jsonNode.get("StartTime").asText()));
            controlinfo.setContent(jsonNode.toString());
            controlinfo.setName(jsonNode.get("DataHeaderName").asText());
            controlinfo.setTestname(jsonNode.get("TestName").asText());
            if (selectControlinfo == null) {
                boolean insert = controlinfoService.insertControlInfoTable(jsonNode.get("TestName").asText() + "/" + jsonNode.get("DataHeaderName").asText(), controlinfo);
                if (insert) {
                    //先清除，再插入到缓存表id和groupname
//                    controlcacheService.deleteAllControlcache(jsonNode.get("TestName").asText());
                    JsonNode channelInfoList = jsonNode.get("ChannelInfoList");
                    List<Controlcache> controlcacheList = new ArrayList<>();
                    for (JsonNode node : channelInfoList) {
                        Controlcache controlcache = new Controlcache();
                        controlcache.setLoopid(Integer.parseInt(node.get("Id").asText()));
                        controlcache.setGroupname(jsonNode.get("DataHeaderName").asText());

                        controlcacheList.add(controlcache);
                    }
                    controlcacheService.insertTable(jsonNode.get("TestName").asText(), controlcacheList);
                    boolean connect = mqttconfig.controlConnect(jsonNode.get("DataHeaderName").asText());
                    boolean sequence = controlorigindataService.createSequence(jsonNode.get("TestName").asText(), jsonNode.get("DataHeaderName").asText());
                    if (connect && sequence) {
                        return new apiDataModel<>(200, "success", jsonNode.get("TestName").asText() + "配置成功");
                    } else {
                        return new apiDataModel<>(404, "false", jsonNode.get("TestName").asText() + "配置失败");
                    }
                } else {
                    return new apiDataModel<>(404, "false", jsonNode.get("TestName").asText() + "配置失败");
                }
            } else {
                boolean update = controlinfoService.updateControlInfoTable(jsonNode.get("TestName").asText(), controlinfo);
                if (update) {
                    return new apiDataModel<>(200, "success", jsonNode.get("TestName").asText() + "更新配置成功");
                } else {
                    return new apiDataModel<>(404, "false", jsonNode.get("TestName").asText() + "更新配置失败");
                }
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new apiDataModel<>(404, "false", "配置失败");
        }

//        //删除measureinfo表数据，正常情况是清除原有测点，更换测点的数量
//        boolean delMeasureinfo = measureinfoService.deleteAllMeasureinfo(controlInfoJson.getTestname());
//        //删除measurecache表数据，正常情况是清除原有测点缓存值及时间，更换测点的数量
//        boolean delMeasurecache = measurecacheService.deleteAllMeasurecache(controlInfoJson.getTestname());
//        boolean insertMeasureinfo = measureinfoService.insertTable(controlInfoJson.getTestname(), controlInfoJson.getChannelinfolist());
//        List<Measurecache> measurecacheList = new ArrayList<>();
//
//        for (int i = 1; i <= controlInfoJson.getChannelinfolist().size(); i++) {
//            Measurecache measurecache = new Measurecache();
//            measurecache.setPointlabel(i);
//            measurecacheList.add(measurecache);
//        }
//        boolean insertMeasurecache = measurecacheService.insertTable(controlInfoJson.getTestname(), measurecacheList);
////        boolean connect = mqttconfig.connect(controlInfoJson.getTestname());
////        if (connect && insertMeasureinfo && delMeasureinfo && delMeasurecache && insertMeasurecache) {
//        if (insertMeasureinfo && delMeasureinfo && delMeasurecache && insertMeasurecache) {
//            return new apiDataModel<>(200, "success", controlInfoJson.getTestname() + "配置成功");
//        } else {
//            return new apiDataModel<>(404, "false", controlInfoJson.getTestname() + "配置失败");
//        }
    }

    //初始化模式，方便后续开始试验
    @CrossOrigin()
    @RequestMapping(value = "/createInit/{topicName}", method = RequestMethod.POST)
    public String createInit(@PathVariable String topicName, @RequestBody testInfoJson json) {
        System.out.println(json);
        //创建模式 表 触发器 序列
        boolean insertSuccess = mqttService.insertInitTable(topicName, json);
        boolean updateSuccess = false;
        if (insertSuccess) {
            //更改表为超表
            updateSuccess = mqttService.updateHypertable(topicName);
        }
        if (insertSuccess && updateSuccess) {
            return topicName + "初始化创建模式、表、触发器、序列、超表";
        } else {
            return topicName + "初始化失败或该名称已存在";
        }
    }

    @RequestMapping("/createExperiment/{tableName}")
    public String createExperiment(@PathVariable String tableName) {
        System.out.println(tableName);
        return tableName;
    }

    @RequestMapping("/")
    public String createExperiment() {
        System.out.println("test");
        return "test";
    }

//    @RequestMapping("/disConnect")
//    public String disConnect() {
//        mqttconfig.disConnect();
//        return clientId + "与服务器断开连接";
//    }

    //断开mqtt链接
    @CrossOrigin()
    @RequestMapping("/disConnect/{topicName}")
    public String disConnect(@PathVariable String topicName) {
        boolean b = mqttconfig.disConnect(topicName);
        if (b) {
            //更新试验结束时间
            UpdateWrapper<Testinfo> wrapper = new UpdateWrapper<>();
            wrapper.eq("topic", topicName);
            OffsetDateTime currentDateTime = OffsetDateTime.now();
            wrapper.set("endtime", currentDateTime);
            wrapper.set("teststatus", 2);
            testinfoService.update(wrapper);
            return topicName + "与服务器断开连接成功";
        } else {
            return topicName + "与服务器断开连接失败";
        }
    }

    //删除模式，也就是试验
    @CrossOrigin()
    @RequestMapping("/dropSchema/{topicName}")
    public String dropSchema(@PathVariable String topicName) {
        boolean b = mqttService.dropSchema(topicName);
        if (b) {
            return "删除试验" + topicName + "成功";
        } else {
            return "删除试验" + topicName + "失败";
        }
    }

    //前端web历史试验
    @CrossOrigin()
    @RequestMapping("/selectAll")
    public String selectAll(@RequestBody pageJson json) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
        System.out.println(json);
        System.out.println(json.getCurrent());
        System.out.println(json.getSize());
        System.out.println(json.getTestnamekeyword());
        List<Testinfo> testinfos = mqttService.selectAll(json.getCurrent(), json.getSize(), json.getTestnamekeyword());

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode testinfoArray = objectMapper.createArrayNode();

        for (Testinfo testinfo : testinfos) {
            // 将Testinfo对象转换为JSON对象
            ObjectNode testinfoNode = objectMapper.valueToTree(testinfo);
            testinfoArray.add(testinfoNode);
        }

        ObjectNode result = objectMapper.createObjectNode();
        result.set("testinfos", testinfoArray);
        result.put("num", testinfos.size());

        try {
//            return objectMapper.writeValueAsString(testinfos);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * param1:begintime
     * param2:endtime
     */
    @CrossOrigin()
    @RequestMapping("/selectTestTime")
    public List<TestTime> selectTestTime(@RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        List<TestTime> list = new ArrayList<>();
        try {
            jsonNode = objectMapper.readTree(json);
            List<Testinfo> testinfos = testinfoService.selectTestTime(jsonNode.get("begintime").asText(), jsonNode.get("endtime").asText());
            for (Testinfo testinfo : testinfos) {
                if (testinfo.getEndtime() != null) {
                    list.add(new TestTime(testinfo.getTestname(), ((testinfo.getEndtime().getTime() - testinfo.getBegintime().getTime()) / (60 * 60 * 1000)) + "h"));
                } else {
                    list.add(new TestTime(testinfo.getTestname(), ((new Timestamp(System.currentTimeMillis()).getTime() - testinfo.getBegintime().getTime()) / (60 * 60 * 1000)) + "h"));
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }

    @CrossOrigin()
    @RequestMapping("/selectTest")
    public String selectTest() {
        List<Testinfo> testinfos = testinfoService.selectTest();

        ObjectMapper objectMapper = new ObjectMapper();
//        for (Testinfo testinfo : testinfos) {
//            if (testinfo.getEndtime() == null) {
//                testinfo.setEndtime(new Timestamp(System.currentTimeMillis()));
//            }
//        }
        try {
            return objectMapper.writeValueAsString(testinfos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    //3D界面历史试验
    @CrossOrigin()
    @RequestMapping("/threeDimensionalSelectAll")
    public String threeDimensionalSelectAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Testinfo> testinfos = mqttService.threeDimensionalSelectAll();
        try {
            return objectMapper.writeValueAsString(testinfos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    //3D界面指定试验的测点查询
    @CrossOrigin()
    @RequestMapping("/measureInfoSelectAll")
    public String measureInfoSelectAll(@RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            List<Measureinfo> measureinfos = measureinfoService.selectAllMeasureinfo(jsonNode.get("schemaname").asText());
            return objectMapper.writeValueAsString(measureinfos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}