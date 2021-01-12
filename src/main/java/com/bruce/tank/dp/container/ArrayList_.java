package com.bruce.tank.dp.container;

import java.util.Arrays;

public class ArrayList_<E> implements Collection_<E> {
    // 大小
    private int size;
    //
    private transient int modCount;
    // {} ?
    private transient Object[] elementData = {};

    @Override
    public int Size() {
        return size;
    }

    @Override
    public Iterator_<E> iterator() {
        return new Itr<E>();
    }

    @Override
    public void add(E element) {
        if (size == elementData.length)
            grow();

        elementData[size] = element;
        size++;
    }

    /**
     * 增长容量
     */
    void grow() {
        modCount++;
        int oldCapacity = elementData.length;
        int newCapacity = 0;
        if (oldCapacity == 0)
            newCapacity = 8;
        else
            newCapacity = oldCapacity * 2;

        Object[] newElementData = Arrays.copyOf(elementData, newCapacity);
        elementData = newElementData;
    }

    private class Itr<E> implements Iterator_<E> {
        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            Object object = elementData[index];
            index++;
            return (E) object;
        }
    }
}
