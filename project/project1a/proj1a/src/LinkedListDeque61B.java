import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    // 节点类改为private（之前的修改保持）
    private class Node {
        Node next;
        Node prev;
        T value;
    }

    private int size;
    private final Node sentinel;  // 哨兵节点（替代原来的head和tail）

    // 构造函数：初始化哨兵节点（自身成环）
    public LinkedListDeque61B() {
        sentinel = new Node();
        sentinel.next = sentinel;  // 哨兵的next指向自己
        sentinel.prev = sentinel;  // 哨兵的prev指向自己
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node();
        newNode.value = x;

        // 新节点插入到哨兵和哨兵的next之间
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node();
        newNode.value = x;

        // 新节点插入到哨兵的prev和哨兵之间
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node current = sentinel.next;  // 从哨兵的next开始遍历（跳过哨兵）
        while (current != sentinel) {  // 遍历到哨兵为止
            returnList.add(current.value);
            current = current.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node first = sentinel.next;
        T value = first.value;

        // 移除第一个节点（哨兵的next）
        sentinel.next = first.next;
        first.next.prev = sentinel;

        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node last = sentinel.prev;
        T value = last.value;

        // 移除最后一个节点（哨兵的prev）
        sentinel.prev = last.prev;
        last.prev.next = sentinel;

        size--;
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = sentinel.next;  // 从第一个实际节点开始
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);  // 从第一个实际节点开始递归
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.value;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}