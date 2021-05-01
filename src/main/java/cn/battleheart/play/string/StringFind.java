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
     * 🔽
     * g o o d g o o g l e
     * g o o g l e
     * 🔼
     * 🔽
     * g o o d g o o g l e
     * g o o g l e
     * 🔼
     * 🔽
     * g o o d g o o g l e
     * g o o g l e
     * 🔼
     * 🔽
     * g o o d g o o g l e
     * g o o g l e
     * 🔼
     *
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

    /**
     * kmp中获取next值。
     * 规则如下：
     * 1. 当模式串中的p[j]=p[k]时，next[j]=k+1;
     * 2. 当模式串中的p[j]≠p[k]时，需要回溯到上次相同的位置，也就是k=next[k]的位置。
     *
     * @param text 需要转换为next值的字符串。
     * @return 返回next的集合信息。
     */
    public static int[] getNext(String text) {
        int[] next = new int[text.length()];
        int j = 0;
        int k = -1;
        next[0] = k;
        while (j < text.length() - 1) {
            if (k == -1 || text.charAt(j) == text.charAt(k)) {
                ++j;
                ++k;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 匹配子串在主串的首位置。
     *
     * @param s         主字符串。
     * @param subString 子串。
     * @return 返回位置。
     */
    public static int getKmpIndexString(String s, String subString) {
        int i = 0;
        int j = 0;
        int[] next = getNext(subString);

        while (i < s.length() && j < subString.length()) {
            if (j == -1 || s.charAt(i) == subString.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > subString.length() - 1) {
            return i - subString.length();
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] ababaaababas = getNext("ababaaababaa");
        for (int i = 0; i < ababaaababas.length; i++) {
            System.out.print(ababaaababas[i] + " ");
        }

        System.out.println();
        int index = getKmpIndexString("ababaaababaa", "aaab");
        System.out.println(index);

    }
}
