package com.bruce.tank.dp.prototype.v3;

import java.io.Serializable;

public class T02 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 手动实现深克隆
        Person p1 = new Person("王");
        Person p2 = (Person) p1.clone();
        p1.name = "李四";
        System.out.println("p1.name=" + p1.name);
        System.out.println("p2.name=" + p2.name);
        System.out.println(p1 == p2);
        System.out.println("p1.location.name == p2.location.name ?" + p1.location.name == p2.location.name);
        p1.location.name = "上海";
        System.out.println("p1.location.name =" + p1.location.name + ",p2.location.name=" + p2.location.name);
        System.out.println("p1.location :" + p1.location + ",p2.location:" + p2.location);
        System.out.println("p1.location == p2.location ?" + p1.location.equals(p2.location));
    }
}

class Person implements Cloneable, Serializable {
    String name;

    transient Location location;

    public Person(String name) {
        this.name = name;
        location = new Location("深圳");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 手动实现深克隆
        Person p = (Person) super.clone();
        p.location = (Location) p.location.clone();
        return p;
    }
}

class Location implements Cloneable {
    String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
