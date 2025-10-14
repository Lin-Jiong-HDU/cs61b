import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        Node next;
        Node prev;
        T value;
    }


    private int size;
    private Node head;
    private Node tail;

    public LinkedListDeque61B() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node();
        newNode.value = x;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node();
        newNode.value = x;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node current = head;
        while (current != null) {
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

        T value = head.value;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T value = tail.value;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        size--;
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current;
        if (index >= size / 2) {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        } else {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }

        return current.value;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.value;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
