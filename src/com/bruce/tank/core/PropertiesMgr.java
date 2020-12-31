package com.bruce.tank.core;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {
    public static final Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        Object o = properties.get(key);
        if (o == null)
            try {
                throw new Exception("无效的配置项：" + key);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        return o;
    }

    public static Integer getInteger(String key) {
        Integer o = Integer.parseInt((String) get(key));
        return o;
    }

    public static String getString(String key) {
        String o = (String) get(key);
        return o;
    }
}
