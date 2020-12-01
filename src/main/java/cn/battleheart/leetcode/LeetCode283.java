package cn.battleheart.leetcode;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums1 = new int[]{2, 1};
        moveZeroes3(nums1);
        System.out.println("-------------------");
        moveZeroes3(nums);
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0;
        int rigiht = 0;
        while (rigiht < length) {
            if (nums[rigiht] != 0) {
                int leftValue = nums[left];
                nums[left] = nums[rigiht];
                nums[rigiht] = leftValue;
                left++;
            }
            rigiht++;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void moveZeroes1(int[] nums) {
        int zeroNum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length) {
                if (nums[i] == 0) {

                }
            }
        }
    }


    public static void moveZeroes2(int[] nums) {

        // 非0的队尾。
        int j = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int num = nums[j];
                nums[j] = nums[i];
                nums[i] = num;
                j++;
            }
            i++;
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
    }

    /**
     * 慢双指针。
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int leftValue = nums[left];
                nums[left] = nums[right];
                nums[right] = leftValue;
                left++;
            }
            right++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
