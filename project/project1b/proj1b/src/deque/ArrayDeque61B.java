package deque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayDeque61B<T> implements Deque61B<T> {

    // 修复构造函数：初始化实例变量而非局部变量
    public ArrayDeque61B() {
        this.AList = (T[]) new Object[2];  // 使用this关键字引用实例变量
        this.size = 0;
    }

    int size;
    T[] AList;

    @Override
    public void addFirst(T x) {
        T[] newArray = (T[]) new Object[AList.length + 1];
        newArray[0] = x;
        System.arraycopy(AList, 0, newArray, 1, size);
        AList = newArray;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == AList.length) {
            extendMemery();
        }
        AList[size] = x;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>(Arrays.asList(AList).subList(0, size));
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
        T removed = AList[0];
        System.arraycopy(AList, 1, AList, 0, size - 1);
        size--;
        AList[size] = null;  // 清除冗余引用

        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = AList[size - 1];
        AList[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {  // 增加对负索引的检查
            return null;
        }
        return AList[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public void extendMemery() {
        AList = Arrays.copyOf(AList, AList.length * 2);
    }

    // 实现迭代器接口
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    // 内部迭代器实现类
    private class ArrayDequeIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("没有更多元素");
            }
            T item = AList[currentIndex];
            currentIndex++;
            return item;
        }

        // 可选：不支持迭代过程中删除元素
        @Override
        public void remove() {
            throw new UnsupportedOperationException("不支持删除操作");
        }
    }

    public int length() {
        return AList.length;
    }
}
