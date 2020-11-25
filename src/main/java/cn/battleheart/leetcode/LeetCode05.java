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
        System.out.println(longestPalindrome2("cbbd"));
        System.out.println(longestPalindrome2("asddsaasdasdasdasd"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("a"));
        System.out.println(longestPalindrome2("ac"));
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

    /**
     * 最长回文子串第二种解答方式。
     * 中心扩散法，原则是找到一个值代表需要往两边扩散对比这个值两边的内容是否一致，如果一致继续扩散，需要注意的是扩散分为奇数扩散和偶数扩散。
     *
     * @param s 字符串。
     * @return 返回最长回文子串。
     */
    public static String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(i, i, s);
            int len2 = expandAroundCenter(i, i + 1, s);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                startIndex = i - (len - 1) / 2;
            }
        }
        return s.substring(startIndex, maxLength + startIndex);

    }

    /**
     * 最长回文子串第二种解答方式。
     * 中心扩散法，原则是找到一个值代表需要往两边扩散对比这个值两边的内容是否一致，如果一致继续扩散，需要注意的是扩散分为奇数扩散和偶数扩散。
     *
     * @param s 字符串。
     * @return 返回最长回文子串。
     */
    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(i, i, s);
            int len2 = expandAroundCenter(i, i + 1, s);
            int len = Math.max(len1, len2);
            if (endIndex - startIndex + 1 < len) {
                startIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }
        }
        return s.substring(startIndex, endIndex + 1);

    }

    /**
     * 中心扩散的方法，中心扩散相比暴力解法，暴力解法是从两边往里面进行回文对比而中心扩散法是从中心往两侧进行扩散。
     *
     * @param left  扩散左侧指针。
     * @param right 扩散的右侧指针。
     * @param s     字符串。
     * @return 返回长度。
     */
    private static int expandAroundCenter(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            right++;
        }
        // 这里计算方式是由于上面最后一次计算完之后本身left已经减少一个了所以right-left会变大一个所以需要减少1
        return right - left - 1;
    }

    /**
     * 动态规划算法。
     *
     * @param s 字符串信息。
     * @return 返回最长子回文串。
     */
    public static String longestPalindrome3(String s) {
        // 动态规划的二维数组长度。
        boolean dp[][] = new boolean[s.length()][s.length()];
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            while (j - i < 3 && s.charAt(i) == s.charAt(j)) {

            }
        }
        return "";
    }
}
