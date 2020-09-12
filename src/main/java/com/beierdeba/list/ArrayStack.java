package com.beierdeba.list;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Administrator
 * @since 2020/9/12 21:48
 */
public class ArrayStack<E> implements Stack<E> {

    // 元素的个数
    private int size;

    // 栈顶指针, -1代表空栈
    private int top = -1;

    // 存放元素的数组
    private transient Object[] elementData;

    // 默认的数组长度是10
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        ensureCapacityInternal(size + 1);
        elementData[++top] = e;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E)elementData[top];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        return (E)elementData[top--];
    }

    public int size() {
        return size;
    }

    public int length() {
        return elementData.length;
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        stack.push("11");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.length());
    }
}
