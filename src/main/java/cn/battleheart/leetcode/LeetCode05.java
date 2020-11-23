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
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("asddsaasdasdasdasd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }

    /**
     * 方法一：暴力破解方法。
     * 原理就是所有字符串都比较一遍是否是回文子串，从两个字符到结尾
     * 回文子串的含义：a[i]=a[length-1]的数字，如果不是则不是回文。直接退出就行。
     *
     * @param s 字符串。
     * @return 返回最大回文子串。
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int length = s.length();
        int maxLength = 1;
        int startIndex = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = i + 1; k < s.length(); k++) {
                if (k - i + 1 > maxLength && validate(s, i, k)) {
                    maxLength = k - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * 验证是不是回文子串的方法。
     *
     * @param s     字符串。
     * @param start 开始位置。
     * @param end   结束为止。
     * @return 返回true=是，返回false=不是。
     */
    private static boolean validate(String s, int start, int end) {
        while (end > start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}
