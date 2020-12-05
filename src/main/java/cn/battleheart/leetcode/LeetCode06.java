package cn.battleheart.leetcode;

import java.nio.charset.Charset;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode06 {

    /**
     * 解题思路：通过记录所有行的内容，然后再根据所有行的内容拼接语句。并且按照Z的形式标记每个字符出现的行。
     *
     * @param s       字符串。
     * @param numRows 行数。
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int size = Math.min(numRows, s.length());
        String[] rows = new String[size];
        //设置为空。
        for (int i = 0; i < rows.length; i++) {
            rows[i] = "";
        }
        boolean down = true;
        boolean up = false;
        int rowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[rowIndex] = rows[rowIndex] + s.charAt(i);
            if (rowIndex == size - 1) {
                up = true;
                down = false;
            }
            if (rowIndex == 0) {
                up = false;
                down = true;
            }
            if (down) {
                rowIndex++;
            }
            if (up) {
                rowIndex--;
            }
        }
        String ss = "";
        for (int i = 0; i < rows.length; i++) {
            ss = ss + rows[i];
        }
        return ss;
    }


    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 2));
    }
}
