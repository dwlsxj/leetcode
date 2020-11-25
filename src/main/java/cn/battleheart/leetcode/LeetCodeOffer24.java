package cn.battleheart.leetcode;

public class LeetCodeOffer24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(6);
        listNode4.next = listNode5;
        ListNode newHead = reverseList(listNode);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            if (newHead == null) {
                newHead = listNode;
            } else {
                listNode.next = newHead;
                newHead = listNode;
            }
            head = head.next;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
