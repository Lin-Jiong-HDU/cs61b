import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        Node next;
        Node prev;
        T value;
    }

    private int size;
    Node head;
    Node tail;
    Node current;

    public LinkedListDeque61B() {
        size = 0;
        head = new Node();
        tail = head;
        current = head;
        return;
    }


    @Override
    public void addFirst(T x) {
        if (size == 0) {
            head.value = x;
            size++;
        } else {
            size++;
            Node temp = new Node();
            temp.value = x;
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    @Override
    public void addLast(T x) {
        if (size == 0) {
            head.value = x;
            size++;
        } else {
            Node temp = new Node();
            temp.value = x;
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
            size++;
        }
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            returnList.add(temp.value);
            temp = temp.next;
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
        if (size == 0) {
            return null;
        }
        head.next.prev = null;
        head = head.next;
        size--;
        return null;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return null;
    }


    public T getOld(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T returnValue = current.value;
        current = head;
        return returnValue;
    }

    // Optimized
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index >= size/2) {
            current = tail;
            for (int i = index + 1; i < size; i++) {
                current = current.prev;
            }
            T returnValue = current.value;
            current = head;
            return returnValue;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T returnValue = current.value;
        current = head;
        return returnValue;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0 || index >= size) {
            T value = current.value;
            current = head;
            return value;
        }
        current = current.next;
        index--;
        return getRecursive(index);
    }
}
