package com.zxoho.demo.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: paydemo
 * Created by admin on 2018/12/7 20:25
 */
public class CommonParam {

    public static Map<String, String> buildCommonParamMap(){
        Map<String, String> params = new HashMap<>();
        params.put("appid", "00008496");
        params.put("cusid", "990651058126043");
        params.put("version", "11");
        params.put("randomstr", System.currentTimeMillis() + "");
        return params;
    }
}