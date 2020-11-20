package cn.battleheart.leetcode;

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
