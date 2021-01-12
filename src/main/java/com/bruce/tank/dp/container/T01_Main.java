package com.bruce.tank.dp.container;

import java.util.ArrayList;

public class T01_Main {
    public static void main(String[] args) {
        Collection_ collection_ = new ArrayList_<Integer>();
        System.out.println(collection_.Size());
        for (int i = 0; i < 10; i++) {
            collection_.add(i);
        }

        System.out.println(collection_.Size());

        Iterator_<Integer> iterator = collection_.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println((next));
        }
    }
}
