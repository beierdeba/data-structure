package com.beierdeba.list;

import java.util.EmptyStackException;

/**
 * @author Administrator
 * @since 2020/9/12 22:09
 */
public class LinkedStack<E> implements Stack<E> {

    private int size;

    // 只有一个指向
    private Node<E> top;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkedStack() {}

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        // 如果是空栈
        if (isEmpty()) {
            top = new Node<>(e, null);
        } else {
            this.top = new Node<>(e, this.top);
        }
        size++;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = top.item;
        top = top.next;
        size--;
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> sl = new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        System.out.println(sl.peek());
        sl.push("C");
        int length = sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->" + sl.pop());
        }
    }
}
