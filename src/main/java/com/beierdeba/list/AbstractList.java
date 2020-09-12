package com.beierdeba.list;

/**
 * @author Administrator
 * @since 2020/9/12 15:36
 */
public abstract class AbstractList<E> implements List<E> {
    // 包含的元素的个数, 不是数组的长度
    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        int i = indexOf(o);
        return i != -1;
    }

    // 防止数据越界
    protected void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
