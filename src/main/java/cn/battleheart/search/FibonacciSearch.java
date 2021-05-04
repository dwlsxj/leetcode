package cn.battleheart.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 斐波拉契数列查找方式。
 * <p>
 * 对上述折半查找在进行优化，算法是：mid=low+F[k-1]-1;
 * 核心：
 * 1. 当key= a[mid]时，查找就成功。
 * 2. 当key< a[mid]时，新范围就是low个到第mid-1个，此时范围个数为F[k-1]-1个。
 * 3. 当key> a[mid]时，新范围就是mid+1个到high个，此时范围个数为F[k-2]-1个。
 * 为什么这么说呢？原因很简单因为它是按照斐波拉契数列来进行分割的，所以数量当然和斐波拉契数列是一致的，因为第k个数列的大小是k-1和k-2之和。
 *
 * @author <a href="mailto:dwlsxj@126.com">battleheart</a>
 * @since 2021年05月04日16:24:42
 */
public class FibonacciSearch {

    /**
     * 斐波拉契数列查找方式。
     *
     * @param array 有序数组。
     * @param n     从第n列前面查找。
     * @param key   查找的值。
     * @return 返回下标。
     */
    public static int fibonacciSearch(List<Integer> array, int n, int key) {

        int low = 0;
        int high = n;
        int k = 0;
        // 首先确定第一个斐波拉契数列的位置。
        while (key > fibonacci(k) - 1) {
            k++;
        }
        // 如果超出了斐波拉契返回的值，则将最后一个值补充上。也就是99，99，99，99，这样子的。
        for (int i = n + 1; i < fibonacci(k) - 1; i++) {
            array.add(array.get(n));
        }
        while (low <= high) {
            int mid = low + fibonacci(k - 1) - 1;
            if (key < array.get(mid)) {
                high = mid - 1;
                k = k - 1;
            } else if (key > array.get(mid)) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= n + 1) {
                    return mid;
                } else {
                    return n;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>(100);
        List<Integer> array1 = Arrays.asList(0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99);
        array.addAll(array1);
        System.out.println(fibonacciSearch(array, array1.size() - 1, 99));
    }

    /**
     * 返回斐波拉契数列。
     * 斐波拉契数列:
     * 第一位为0
     * 第二位为1
     * 第n位为F(n-1)+F(n-2)
     *
     * @param n 第n个斐波拉契数列。
     * @return 返回第n个斐波拉契数列。
     */
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n == 0 ? 0 : 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
