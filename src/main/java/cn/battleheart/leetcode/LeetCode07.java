package cn.battleheart.leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class LeetCode07 {

    public static int reverse(int x) {
        // 保存余数。
        int remainder = 0;
        int newX = 0;

        while (x / 10 != 0 || x % 10 != 0) {
            remainder = x % 10;
            //判断是否 大于 最大32位整数
            if (newX > 214748364 || (newX == 214748364 && remainder > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (newX < -214748364 || (newX == -214748364 && remainder < -8)) {
                return 0;
            }
            newX = newX * 10 + remainder;
            x = x / 10;
        }
        return newX;
    }

    public static void main(String[] args) {
        System.out.println(reverse(124));
        System.out.println(reverse(120));
        System.out.println(reverse(100));
        System.out.println(reverse(103));
        System.out.println(reverse(900000));

    }
}
