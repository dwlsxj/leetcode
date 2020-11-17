package cn.battleheart.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2. 两数相加。
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode02 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(7)));
        System.out.println(addTwoNumbers(listNode1, listNode2));
    }

    /**
     * 第二版解决方案。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        // 头结点。
        ListNode head = null;
        // 尾结点。
        ListNode tail = null;

        int carryBit = 0;
        while (l1 != null || l2 != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (l1 != null) {
                l1Value = l1.val;
            }
            if (l2 != null) {
                l2Value = l2.val;
            }
            // 两个数之和。
            int sum = l1Value + l2Value + carryBit;
            int currentValue = sum % 10;
            carryBit = sum / 10;
            if (head == null) {
                head = tail = new ListNode(currentValue);
            } else {
                tail.next = new ListNode(currentValue);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carryBit != 0) {
                tail.next = new ListNode(carryBit);
            }
        }
        return head;
    }

    /**
     * 第一版解题思路。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        // 初始化一个内容。
        List<ListNode> listNode = new ArrayList<>();

        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        int carryBit = 0;
        while (l1Temp != null || l2Temp != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (l1Temp != null) {
                l1Value = l1Temp.val;
            }
            if (l2Temp != null) {
                l2Value = l2Temp.val;
            }
            // 两个数之和。
            int sum = l1Value + l2Value + carryBit;
            int currentValue;
            if (sum >= 10) {
                currentValue = sum % 10;
                carryBit = sum / 10;
            } else {
                currentValue = sum;
                carryBit = 0;
            }
            listNode.add(new ListNode(currentValue));
            if (l1Temp != null) {
                l1Temp = l1Temp.next;
            }
            if (l2Temp != null) {
                l2Temp = l2Temp.next;
            }
        }
        // 如果进位不等于0贼进行进位操作。
        if (carryBit != 0) {
            listNode.add(new ListNode(carryBit));
        }
        System.out.println(listNode);
        ListNode listNode1 = null;
        for (int i = listNode.size() - 1; i >= 0; i--) {
            if (i == listNode.size() - 1) {
                if (i - 1 >= 0) {
                    listNode1 = new ListNode(listNode.get(i - 1).val, listNode.get(i));
                } else {
                    return listNode.get(i);
                }
            } else {
                if (i - 1 >= 0) {
                    listNode1 = new ListNode(listNode.get(i - 1).val, listNode1);
                }
            }
        }
        return listNode1;
    }

    /**
     * 链表内容。
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
