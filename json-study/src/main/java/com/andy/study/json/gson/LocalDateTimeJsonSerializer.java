package com.andy.study.json.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @time: 2020/12/3 十二月 15:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LocalDateTimeJsonSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type typeOfSrc, JsonSerializationContext context) {
        if(localDateTime==null){
            return new JsonObject();
        }
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
