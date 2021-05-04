package cn.battleheart.search;

/**
 * 插值查找，是在折半查找的基础上进行添加的,
 * 因为折半查找算法是：
 * <p>
 * mid=(high+low)/2=low+(high-low)/2，那么将1/2变换为(key-a[low])/(a[high]-a[low])插值公式算法。
 * <p>
 * 插值查找是根据要查找的关键字key与查找表中最大和最小记录的关键字比较后的查找方法，其核心就在于插值计算公式(key-a[low])/(a[high]-a[low])
 * <p>
 * mid=low+((key-a[low])/(a[high]-a[low]))*(high-low)
 *
 * @author <a href="mailto:dwlsxj@126.com">battleheart</a>
 * @since 2021年05月04日16:24:48
 */
public class InterpolationSearch {

    /**
     * 插值查找方法。
     *
     * @param array 有序数组。
     * @param n     从第n列前面查找。
     * @param key   查找的值。
     * @return 返回下标。
     */
    public static int binarySearch(int[] array, int n, int key) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + ((key - array[low]) / (array[high] - array[low])) * (high - low);
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        System.out.println(binarySearch(array, array.length - 1, 88));
    }
}
