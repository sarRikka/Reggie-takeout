package com.cyy.takeout.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Shm;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    
    int code;
    
    String msg;
    
    T data;
    
    Map map=new HashMap();
    
    public static <T> R<T> success(T data)
    {
        R r=new R<T>();
        r.setCode(1);
        r.setData(data);
        return r;
    }
    
    public static <T> R<T> error(String msg)
    {
        R<T> r=new R<>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }    
    
    public R<T> add(String key,String value)
    {
        this.map.put(key,value);
        return this;
    }
    
}
