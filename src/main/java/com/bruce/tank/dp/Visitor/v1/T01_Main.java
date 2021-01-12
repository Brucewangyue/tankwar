package com.bruce.tank.dp.Visitor.v1;

/**
 * 通过访问者模式
 */
public class T01_Main {
    public static void main(String[] args) {
        System.out.println(new Product().getPrice());
    }
}

class Product {
    long getPrice() {
        long price = 0L;
        price += new Computer().getPrice("个人");
        price += new CPU().getPrice("个人");
        return price;
    }
}

interface ComputerPart {
    long getPrice(String type);
}

class Computer implements ComputerPart {
    private long price = 500;

    public long getPrice(String type) {
        // 需要在每个产品里判断、验证逻辑分散

        if (type == "个人")
            price *= 0.9;
        else if (type == "企业")
            price *= 0.8;

        return price;
    }
}

class CPU implements ComputerPart {
    private long price = 300;

    public long getPrice(String type) {
        if (type == "个人")
            price *= 0.9;
        else if (type == "企业")
            price *= 0.8;

        return price;
    }
}