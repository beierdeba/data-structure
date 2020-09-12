package com.beierdeba.list;

/**
 * @author Administrator
 * @since 2020/9/12 15:46
 */
public class LinkedList<E> extends AbstractList<E> {

    // 只有一个指向
    private Node<E> first;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> node(int index) {
        // 因为这是一个单向链表, 所以只能从fast开始查找
        rangeCheck(index);
        Node<E> node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean add(E o) {
        // 如果在表尾加入元素
        add(size(), o);
        return true;
    }

    @Override
    public void add(int index, E e) {
        rangeCheck(index);
        // 特殊情况, 如果是第一次插入
        if (index == 0) {
            first = new Node<>(e, null);
        } else {
            // 拿到插入位置的前一个节点
            Node<E> prev = node(index - 1);
            // 创建新的节点, 把前节点的 next指向新创建的节点
            prev.next = new Node<>(e, prev.next);
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = first;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    remove(i);
                    return true;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(node(i).item)) {
                    remove(i);
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        E item = node.item;
        // 删除表头
        if (index == 0) {
            // 取表头的下个节点覆盖 first
            first = first.next;
        } else {
            // 如果要删除index位置的节点, 需要把index-1的next指向 index.next
            node(index - 1).next = node.next;
            node.item = null;
            node.next = null;
        }
        size--;
        return item;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null;) {
            Node<E> next = x.next;
            x.next = null;
            x.item = null;
            x = next;
        }
        size = 0;
        this.first = null;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = first;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(node(i).item)) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("老五");

        System.out.println("--------新增------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);

        System.out.println("--------删除------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
