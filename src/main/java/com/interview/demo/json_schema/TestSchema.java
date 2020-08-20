package com.interview.demo.json_schema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestSchema {
    public static void main(String[] args) {
        test();
    }

    public static String test() {
        //map转换成json
        Map<String, Object> map = new HashMap<>();
        map.put("name", "a");
        map.put("age", 100);
        JSONObject json = new JSONObject(map);//待校验的数据
        //从文件获取json
        InputStream test = TestSchema.class.getResourceAsStream("/static/schema.json");
        JSONObject Schema = new JSONObject(new JSONTokener(test));//校验标准
        Schema schema = SchemaLoader.load(Schema);
        try {
            schema.validate(json);
            System.out.println("校验成功！");
        } catch (ValidationException e) {
            System.out.println(e.getAllMessages());
        }
        return "hello";
    }
}
