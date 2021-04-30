package cn.battleheart.play.string;


/**
 * 字符串查找。
 * 问题：子串在主串中的位置。
 * 主串：S="goodgoogle" 子串：T="google";
 */
public class StringFind {

    /**
     * 简单匹配算法，暴力匹配。
     * 准备两个指针指向依次进行比较，分别移动子串和主串的位置，依次进行比较，如下所示：
     * 🔽
     * g o o d g o o g l e
     * g o o g l e
     * 🔼
     *   🔽
     * g o o d g o o g l e
     * g o o g l e
     *   🔼
     *     🔽
     * g o o d g o o g l e
     * g o o g l e
     *     🔼
     *       🔽
     * g o o d g o o g l e
     * g o o g l e
     *       🔼
     *   🔽
     * g o o d g o o g l e
     *   g o o g l e
     *   🔼
     * @param s 主串。
     * @param t
     * @return
     */
    public static int getFirstIndex(String s, String t) {
        // s的长度。
        int slength = s.length();
        // t的长度。
        int tlength = t.length();

        // 主串的指针。
        int i = 0;
        // 子串的指针。
        int j = 0;

        while (i <= slength - 1 && j <= tlength - 1) {
            // 如果相等就相加。
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
                ++j;
            } else {
                //回到原位置的下一个位置，原位置是i-j+1,那么下一个位置就是i-j+1+1=i-j+2
                i = i - j + 2;
                // 子串回到原来位置。
                j = 0;
            }
        }
        // 说明遍历完了。
        if (j >= tlength) {
            return i - tlength;
        } else {
            return 0;
        }
    }




    public static void main(String[] args) {
        String s = "goodgoogle";
        String t = "google";
        System.out.println(getFirstIndex(s, t));
    }
}
