package com.beierdeba.list;

/**
 * @author Administrator
 * @since 2020/9/12 21:39
 */
public interface Stack<E> {

    // 判断是否空栈
    boolean isEmpty();

    // 元素入栈
    void push(E e);

    // 返回栈顶元素, 元素未出栈
    E peek();

    // 元素出栈
    E pop();
}
