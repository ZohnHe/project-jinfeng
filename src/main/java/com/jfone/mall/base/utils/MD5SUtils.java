package com.jfone.mall.base.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5SUtils {

    public static String  genMd5(String username,String password) {
        //选择加密类型
        String hashAlgorithmName = "MD5";
        //需要进行加密的密码
        Object credentials = password;
        //使用唯一标识的账号为盐值
        Object salt = ByteSource.Util.bytes(username);
        //加密的次数
        int hashIterations = 1024;
        //返回加密后的数据
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
        return  result.toString();
    }

    public static void main(String[] args) {
        String s = genMd5("842474991", "123456");
        System.out.println(s);
    }}
