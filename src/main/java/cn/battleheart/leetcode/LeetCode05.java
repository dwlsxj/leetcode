package cn.battleheart.leetcode;

/**
 * 5. 最长回文子串
 * 含义:正向和反向是一样的字符串。
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode05 {
    public static void main(String[] args) {
    }

    public String longestPalindrome(String s) {
        int length = s.length();

        // 滑动窗口的方式。
        for (int i = 0; i < s.length(); i++) {

            while (i + 1 < length) {

            }
        }
        return "";
    }
}
