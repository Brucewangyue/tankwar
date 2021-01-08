package com.bruce.tank.dp.proxy.v2;

import java.lang.reflect.Proxy;

/**
 * jdk代理的局限：需要指定一个接口
 */
public class T02_Main_DynamicProxy {
    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // 日志代理
        Fire proxy2 = (Fire) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class, Fire.class}, (proxy, method, methodArgs) -> {
            System.out.println("坦克开始移动");
            Object o = method.invoke(tank, methodArgs);
            System.out.println("坦克停止移动");
            return o;
        });

        System.out.println(proxy2.fire());

        // 记录耗时
        Movable proxy1 = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, (proxy, method, methodArgs) -> {
            long start = System.currentTimeMillis();
            Object o = method.invoke(proxy2, methodArgs);
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start));
            return o;
        });

        proxy1.move();
    }
}

class Tank implements Movable, Fire {
    @Override
    public void move() {
        System.out.println("坦克移动中...");
    }

    @Override
    public long fire() {
        System.out.println("开火...");
        return 1L;
    }
}

interface Movable {
    void move();
}

interface Fire {
    long fire();
}