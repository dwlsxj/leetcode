package cn.battleheart.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode03 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("bbbbb"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
    }

    /**
     * 滑动窗口的方式进行解决问题。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        // 左侧索引
        int rk = -1;
        int maxLength = 0;

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                characters.remove(chars[i - 1]);
            }
            while (rk + 1 < length && !characters.contains(chars[rk + 1])) {
                characters.add(chars[rk + 1]);
                ++rk;
            }
            maxLength = Math.max(maxLength, rk - i + 1);
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> characters = new HashSet<>();
        int maxLengths = 0;
        int rk = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !characters.contains(s.charAt(rk + 1))) {
                characters.add(s.charAt(rk + 1));
                ++rk;
            }
            maxLengths = Math.max(maxLengths, rk - i + 1);
        }
        return maxLengths;
    }


}
