package com.bruce.tank.dp.asm;

public class T1 {
    int i = 1;

    public void m() {
        int k = 0;
        System.out.println(k++);
    }

    public static void main(String[] args) {
        new T1().m();
    }
}
