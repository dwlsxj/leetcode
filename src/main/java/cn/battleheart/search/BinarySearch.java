package cn.battleheart.search;

/**
 * 折半查找，也叫二分查找法。
 * 在有序表中，取中间记录作为比较对象，若给定值与中间记录的关键字相等，则查找成功。
 * 如给定值小于中间记录的关键字，则中间记录的左半区域继续查找；
 * 若给定值大于中间记录的关键字，则中检记录的右半区域继续查找；
 * 不断重复上述过程，直到查找成功，或所有查找区域无记录。查找失败。
 *
 * @author <a href="mailto:dwlsxj@126.com">battleheart</a>
 * @since TODO
 */
public class BinarySearch {

    /**
     * 折半查找方法。
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
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        System.out.println(binarySearch(array, array.length - 1, 0));
    }
}
