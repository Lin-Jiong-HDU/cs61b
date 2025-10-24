package deque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Maximizer61B {
    /**
     * Returns the maximum element from the given iterable of comparables.
     * You may assume that the iterable contains no nulls.
     *
     * @param iterable  the Iterable of T
     * @return          the maximum element
     * @throws NoSuchElementException if the iterable is empty
     */
    public static <T extends Comparable<T>> T max(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();

        // 检查是否为空
        if (!iterator.hasNext()) {
            throw new NoSuchElementException("Iterable is empty, cannot find maximum");
        }

        // 初始化最大值为第一个元素
        T maxElement = iterator.next();

        // 遍历剩余元素，找到最大值
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.compareTo(maxElement) > 0) {
                maxElement = current;
            }
        }

        return maxElement;
    }

    /**
     * Returns the maximum element from the given iterable according to the specified comparator.
     * You may assume that the iterable contains no nulls.
     *
     * @param iterable  the Iterable of T
     * @param comp      the Comparator to compare elements
     * @return          the maximum element according to the comparator
     * @throws NoSuchElementException if the iterable is empty
     */
    public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
        Iterator<T> iterator = iterable.iterator();

        // 检查是否为空
        if (!iterator.hasNext()) {
            throw new NoSuchElementException("Iterable is empty, cannot find maximum");
        }

        // 初始化最大值为第一个元素
        T maxElement = iterator.next();

        // 遍历剩余元素，根据比较器找到最大值
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (comp.compare(current, maxElement) > 0) {
                maxElement = current;
            }
        }

        return maxElement;
    }

    public static void main(String[] args) {
        // 测试整数队列
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(5);
        ad.addLast(12);
        ad.addLast(17);
        ad.addLast(23);
        System.out.println("最大整数: " + max(ad)); // 应输出23

        // 测试字符串队列
        ArrayDeque61B<String> stringDeque = new ArrayDeque61B<>();
        stringDeque.addLast("apple");
        stringDeque.addLast("banana");
        stringDeque.addLast("cherry");
        System.out.println("按自然顺序最大的字符串: " + max(stringDeque)); // 应输出cherry

        // 使用比较器测试（按字符串长度）
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        System.out.println("按长度最大的字符串: " + max(stringDeque, lengthComparator)); // 应输出banana
    }
}
