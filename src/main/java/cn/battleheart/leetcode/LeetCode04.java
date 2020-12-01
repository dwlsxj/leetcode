package cn.battleheart.leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3)  2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode04 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println();

        int[] nums3 = new int[]{1, 2};
        int[] nums4 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums3, nums4));
        System.out.println();


        int[] nums5 = new int[]{0, 0};
        int[] nums6 = new int[]{0, 0};
        System.out.println(findMedianSortedArrays(nums5, nums6));
        System.out.println();

        int[] nums7 = {};
        int[] nums8 = new int[]{1};
        System.out.println(findMedianSortedArrays(nums7, nums8));
        System.out.println();

        int[] nums9 = {};
        int[] nums10 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums10, nums9));
        System.out.println();

        int[] nums11 = {0, 0, 0, 0, 0};
        int[] nums12 = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(findMedianSortedArrays(nums11, nums12));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取总的长度。
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int length = num1Length + num2Length;
        // 新建一个数组存放两个排序好的元素。
        int[] nums = new int[length];

        int i = 0;
        int j = 0;
        int k = 0;
        boolean num1End = false;
        boolean num2End = false;
        while (i < num1Length || j < num2Length) {
            int num1Value = 0;
            int num2Value = 0;
            if (i < num1Length) {
                num1Value = nums1[i];
            } else {
                num1End = true;
            }
            if (j < num2Length) {
                num2Value = nums2[j];
            } else {
                num2End = true;
            }
            if (num1Value <= num2Value && !num1End && !num2End) {
                nums[k] = num1Value;
                i++;
            } else if (num1Value > num2Value && !num1End && !num2End) {
                nums[k] = num2Value;
                j++;
            } else if (num1End && !num2End) {
                nums[k] = num2Value;
                j++;
            } else if (!num1End) {
                nums[k] = num1Value;
                i++;
            }
            k++;
        }

        int value = length / 2;
        int yushu = length % 2;
        if (yushu > 0) {
            return nums[value];
        } else {
            return (nums[value - 1] + nums[value]) / 2.0;

        }
    }
}
