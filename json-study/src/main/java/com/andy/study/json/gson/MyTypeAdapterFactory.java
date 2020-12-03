package com.andy.study.json.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * @time: 2020/12/3 十二月 15:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        return null;
    }
}
