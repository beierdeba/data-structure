package com.beierdeba.list;

/**
 * @author Administrator
 * @since 2020/9/12 13:54
 */
public interface List<E> {

    // 线性表的长度
    int size();

    // 是否是空的线性表
    boolean isEmpty();

    // 是否包含某个元素
    boolean contains(Object o);

    // 表尾插入某个元素
    boolean add(E e);

    // 指定位置插入元素
    void add(int index, E e);

    // 删除某个元素
    boolean remove(Object o);

    // 指定位置删除某个元素
    E remove(int index);

    E get (int index);

    // 清空线性表
    void clear();

    int indexOf(Object o);
}
