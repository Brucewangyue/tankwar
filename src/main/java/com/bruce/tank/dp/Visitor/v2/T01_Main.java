package com.bruce.tank.dp.Visitor.v2;

/**
 * 访问者模式
 */
public class T01_Main {
    public static void main(String[] args) {
        System.out.println(new Product().getPrice());
    }
}

class Product {
    long getPrice() {
        long price = 0L;

        Visitor v = new CorpVisitor();
        ComputerPart p1 = new Computer();
        p1.accept(v);
        price += p1.getPrice();

        ComputerPart p2 = new CPU();
        p2.accept(v);
        price += p2.getPrice();

        return price;
    }
}

abstract class Visitor {
    public long visitComputer(long price) {
        return price;
    }

    public long visitCPU(long price) {
        return price;
    }
}

interface ComputerPart {
    long getPrice();

    void accept(Visitor v);
}

class Computer implements ComputerPart {
    private long price = 500;

    public long getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor v) {
        price = v.visitComputer(price);
    }
}

class CPU implements ComputerPart {
    private long price = 300;

    public long getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor v) {
        price = v.visitCPU(price);
    }
}

class PersonVisitor extends Visitor {
    @Override
    public long visitComputer(long price) {
        return (long) (price * 0.9);
    }

    @Override
    public long visitCPU(long price) {
        return (long) (price * 0.9);
    }
}

class CorpVisitor extends Visitor {
    @Override
    public long visitComputer(long price) {
        return (long) (price * 0.8);
    }

    @Override
    public long visitCPU(long price) {
        return (long) (price * 0.8);
    }
}
