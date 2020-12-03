package com.andy.study.json.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @time: 2020/12/3 十二月 15:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LocalDateJsonDerializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if(json==null || json.getAsString()==null || json.getAsString().length()==0){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateTime = LocalDate.parse(json.getAsString(),formatter);
        return localDateTime;
    }
}
