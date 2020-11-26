package cn.battleheart.leetcode.lagou;

/**
 * 一个很长很长的数组里，如何快速的找到第2大的数，注意时间复杂度和空间复杂度？
 */
public class LaGou01 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 4, 6, 7, 24, 6, 7, 1231, 2, 24, 51, 3, 55};
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1, 4};
        System.out.println(sencondMax(nums));
        System.out.println(sencondMax(nums1));
        System.out.println(sencondMax(nums2));
    }

    /**
     * 找到第二大的数字
     * 1. 判断如果现在这个值大于第一个值，则将第二大的值存放当前最大值，最大值存放当前的i的值
     * 2. 如果当前值小于最大值大于第二大值，则将第二大值修改为最新i值。
     *
     * @param nums 数组。
     * @return 返回第二大的数字。
     */
    private static int sencondMax(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int firstMax = Integer.MIN_VALUE;
        int sencondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                sencondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] < firstMax && nums[i] > sencondMax) {
                sencondMax = nums[i];
            }
        }
        return sencondMax;
    }
}
