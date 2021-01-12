package com.bruce.tank.dp.container;

public class LinkedList_<E> implements Collection_<E>{
    Node head;
    Node tail;
    int size;

    @Override
    public int Size() {
        return 0;
    }

    @Override
    public Iterator_<E> iterator() {
        return null;
    }

    @Override
    public void add(E element) {

    }


    private class Node{

    }

    private class Itr<E> implements Iterator_<E>{

        int index;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
