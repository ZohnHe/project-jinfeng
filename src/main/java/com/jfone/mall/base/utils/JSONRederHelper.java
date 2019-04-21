package com.jfone.mall.base.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JSONRederHelper {

    public static String readerRequest(HttpServletRequest req){
        try {
            //String bodyJson = IOUtils.read(req.getInputStream(),"utf-8");
            String bodyJson = IOUtils.toString(req.getInputStream(),"utf-8");
            System.out.println("bodyJson:"+bodyJson);
            return bodyJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
