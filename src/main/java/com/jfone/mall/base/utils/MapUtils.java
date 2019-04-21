package com.jfone.mall.base.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String,Object> reposCode(String status, String msg){
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);
        map.put("msg",msg);
        return map;
    }
}
