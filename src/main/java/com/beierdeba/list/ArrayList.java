package com.beierdeba.list;

import java.util.Arrays;

/**
 * @author Administrator
 * @since 2020/9/12 14:23
 */
public class ArrayList<E> extends AbstractList<E> {

    // 存在数据的数组
    private transient Object[] elementData;

    // 默认的数组长度是10
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        } else if (initialCapacity == 0) {
            this.elementData = new Object[] {};
        }
        this.elementData = new Object[initialCapacity];
    }

    // 扩容
    private void ensureCapacityInternal(int minCapacity) {
        // 如果超出当前数据的长度, 就需要扩容
        // 函数每次被调用都是 size + 1
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1); // 每次扩容1.5被
            if (newCapacity - minCapacity < 0) { // 如果初始大小是0的特殊情况
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E)elementData[index];
    }

    // 添加元素前先确定是否需要扩容
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    // 在指定位置index添加元素, 需要把原来index以及后面的元素往后移动一位
    public void add(int index, E e) {
        rangeCheck(index);
        ensureCapacityInternal(size + 1);
        // elementData:源数组;
        // index:源数组中的起始位置;
        // elementData：目标数组；
        // index + 1：目标数组中的起始位置；
        // size - index：要复制的数组元素的数量；
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    remove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    remove(index);
                    return true;
                }
        }
        return false;
    }

    // 指定位置删除元素, 需要把index+1往后的元素向前移动一位
    public E remove(int index) {
        rangeCheck(index);
        E e = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return e;
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return 0;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        System.out.println("--------新增------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
