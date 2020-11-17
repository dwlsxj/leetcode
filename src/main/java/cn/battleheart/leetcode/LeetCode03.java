package cn.battleheart.leetcode;

import java.util.ArrayList;
import java.util.List;

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
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxlength = 0;
        int add = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            boolean chongfu = false;
            char aChar = chars[i];
            char nextChar = chars[i + 1];
            // 校验是否重复。
            for (String s1 : strings) {
                char[] chars1 = s1.toCharArray();
                char c = chars1[0];
                if (aChar == c) {
                    chongfu = true;
                }
            }
            if (i + 1 < chars.length) {
                int r = aChar ^ nextChar;
                if (r != 0 && !chongfu) {
                    // 将元素添加到非重复元素集合中。
                    strings.add(new String(new char[]{aChar}));
                    add = add + 1;
                } else {

                }
            } else {
                //最后一个元素。
                if (!chongfu) {
                    add += 1;
                }
            }
        }
        return 0;
    }
}
