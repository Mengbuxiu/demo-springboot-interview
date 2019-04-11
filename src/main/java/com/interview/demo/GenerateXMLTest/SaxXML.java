package com.interview.demo.GenerateXMLTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class SaxXML {
    public static void main(String[] args) {

        /**
         * 做个json串
         * */
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("rowid", "11111111111111111111");
            put("table", "test_table");
            put("client_ip", "172.1.1.1(c)");
            put("node_id", "ada-sdsaf-ssadsa-sad");
            put("computer_name", "king_zl");
            put("app_user", "路人甲");
            put("department", "某部门");
            put("program", "部件");
            put("facility", "[保留项]");
            put("object", new ArrayList<String>() {{
                add("test_obj_name——1");
                add("test_obj_name——2");
            }});
            put("detail", "this is threat tip");
            put("result", "成功处理风险");
            put("reqtime", LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
            put("threat", "3");
            put("type", "2");
            put("produce_type", "aaaaa");
            put("behavior_type", "行为类别");
            put("reservation", "[保留项]");
        }};

        Object json = JSON.toJSON(map);
        System.out.println(json);

        // 调用sax生成xml方法
        try {
            createSAX(new File("R:\\sax.xml"), json.toString());
        } catch (SAXException | TransformerConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void createSAX(File file, String json) throws SAXException, TransformerConfigurationException, FileNotFoundException {
        //准备的数据
        JSONObject object = JSONObject.parseObject(json);
        Map map = object.toJavaObject(Map.class);
//        JSONArray list = (JSONArray) map.get("object");
//        for (Object o : list) {
//            System.out.println(o);
//        }

        // 创建sax转换工厂
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

        // 创建TransformerHandler
        TransformerHandler handler = factory.newTransformerHandler();

        // 创建handler转换器
        Transformer transformer = handler.getTransformer();
        // 缩进
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // 字符集
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

        // 创建Result连接到xml文件
        Result result = new StreamResult(new FileOutputStream(file));
        handler.setResult(result);

        //------------------------正文开始-------------------------------

        // 创建属性, addAttribute(String uri, String localName, String qName, String type, String value)
        AttributesImpl attr = new AttributesImpl();
        //填充属性的条件
        LinkedHashMap<String, String> condition = new LinkedHashMap<>();
        // 打开doc对象
        handler.startDocument();
        condition.put("tablename", String.valueOf(map.get("table")));
        condition.put("Remark", "审计日志");

        // (xmlns,未知, node, property)
        //根节点 -> Log
        handler.startElement(null, null, "Log", generateAttr(attr, condition));

        //(xmlns,未知,node,property)
        condition.put("Remark", "审计日志");
        //第一个节点 -> LogID
        handler.startElement(null, null, "LogID", generateAttr(attr, condition));
        String value = String.valueOf(map.get("rowid"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "LogID");

        //(xmlns,未知,node,property)
        //第2个节点 -> Subject
        condition.put("Remark", "事件主体");
        handler.startElement(null, null, "Subject", generateAttr(attr, condition));
        //第2个节点的多个子节点 -> ...
        condition.put("Remark", "主体IP地址");
        handler.startElement(null, null, "Node", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("client_ip"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Node");


        // TODO  1.1.1.1 客户端IP去掉间隔符号， 转为int型，乘以3得出ID，共12位，不足12位前面用0补齐
        condition.put("Remark", "主体ID");
        handler.startElement(null, null, "NodeID", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("node_id"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "NodeID");

        // TODO hostname
        condition.put("Remark", "计算机名称");
        handler.startElement(null, null, "ComputerName", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("computer_name"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "ComputerName");

        // TODO dbuser
        condition.put("Remark", "用户名或责任人");
        handler.startElement(null, null, "UserName", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("app_user"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "UserName");

        condition.put("Remark", "部门");
        handler.startElement(null, null, "Department", generateAttr(attr, condition));
        //填值
        value = "保留";
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Department");

        condition.put("Remark", "类型");
        handler.startElement(null, null, "Facility", generateAttr(attr, condition));
        //填值
        value = "保留";
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Facility");

        handler.endElement(null, null, "Subject");

        //第3个节点
        condition.put("Remark", "事件客体");
        handler.startElement(null, null, "Object", generateAttr(attr, condition));

        JSONArray object_name = (JSONArray) map.get("object");

        for (Object o : object_name) {
            condition.put("Remark", "文件名");
            handler.startElement(null, null, "ObjectName", generateAttr(attr, condition));
            //填值
            value = String.valueOf(o);
            handler.characters(value.toCharArray(), 0, value.length());
            handler.endElement(null, null, "ObjectName");
        }

        handler.endElement(null, null, "Object");

        //第4个节点
        condition.put("Remark", "事件内容");
        handler.startElement(null, null, "Details", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("detail"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Details");

        //第5个节点
        condition.put("Remark", "事件结果");
        handler.startElement(null, null, "Result", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("result"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Result");

        //第6个节点
        condition.put("Remark", "发生时间");
        handler.startElement(null, null, "EntryStamp", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("reqtime"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "EntryStamp");

        //第7个节点
        condition.put("Remark", "事件风险级别");
        handler.startElement(null, null, "Level", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("threat"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Level");

        //第8个节点 TODO 可视化工具为m，jdbc连接为a，其它为s，字段是appname
        condition.put("Remark", "事件种类");
        handler.startElement(null, null, "Type", generateAttr(attr, condition));
        //填值
        value = String.valueOf(map.get("type"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Type");

        //第9个节点
        condition.put("Remark", "产品类型");
        handler.startElement(null, null, "ProduceType", generateAttr(attr, condition));
        //填值
        value = "d";
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "ProduceType");

        //第10个节点
        condition.put("Remark", "行为类别");
        handler.startElement(null, null, "BehaviorType", generateAttr(attr, condition));
        //填值
        String behavior_type = (String) map.get("behavior_type");
        switch (behavior_type){
            case "未命中策略":
            default:
                behavior_type = "一般行为";
                break;
            case "命中策略":
                behavior_type = "违规行为";
                break;
            case "基线偏离":
                behavior_type = "异常行为";
                break;

        }
        handler.characters(behavior_type.toCharArray(), 0, behavior_type.length());
        handler.endElement(null, null, "BehaviorType");

        //第11个节点
        condition.put("Remark", "保留项");
        handler.startElement(null, null, "Reservation", generateAttr(attr, condition));
        //保留项，暂时不填值
        value = String.valueOf(map.get("reservation"));
        handler.characters(value.toCharArray(), 0, value.length());
        handler.endElement(null, null, "Reservation");


        handler.endElement(null, null, "Log");
        // 关闭doc对象
        handler.endDocument();
        System.out.println("SAX CreateSAX success!");

    }

    private static AttributesImpl generateAttr(AttributesImpl attr, LinkedHashMap<String, String> condition) {

        // 每次创建节点前，先清空属性，防止属性错误
        attr.clear();
        condition.forEach((k, v) -> {
            Objects.requireNonNull(k);
            Objects.requireNonNull(v);
            // 设置属性
            attr.addAttribute(null, null, k, null, v);
        });
        //清空condition
        condition.clear();
        return attr;
    }

}
