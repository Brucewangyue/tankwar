package com.bruce.tank.dp.prototype.v1;

public class T01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // jdk默认实现的克隆：浅克隆，没有克隆内部属性的引用
        com.bruce.tank.dp.prototype.v1.Person p1 = new com.bruce.tank.dp.prototype.v1.Person("王");
        com.bruce.tank.dp.prototype.v1.Person p2 = (com.bruce.tank.dp.prototype.v1.Person) p1.clone();
        System.out.println("p1.name=" + p1.name);
        System.out.println("p2.name=" + p2.name);
        System.out.println(p1 == p2);
        System.out.println("p1.location.name == p2.location.name ?" + p1.location.name == p2.location.name);
        p1.location.name = "上海";
        System.out.println("p1.location.name =" + p1.location.name +",p2.location.name="+ p2.location.name);
        System.out.println("p1.location :" + p1.location + ",p2.location:" + p2.location);
        System.out.println("p1.location == p2.location ?" + p1.location.equals(p2.location));
    }
}

class Person implements Cloneable {
    String name;

    com.bruce.tank.dp.prototype.v1.Location location;

    public Person(String name) {
        this.name = name;
        location = new com.bruce.tank.dp.prototype.v1.Location("深圳");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location {
    String name;

    public Location(String name) {
        this.name = name;
    }
}
