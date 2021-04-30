package cn.battleheart.leetcode;

/**
 * LRU算法。
 * LRU（Least Recently Used，最近最少使用）算法根据页面的历史请求记录来进行淘汰页面，
 * 其核心思想是 “如果页面数据最近被访问过，那么将来被访问的几率也更高”。
 * 基于这个思想,会存在一种缓存淘汰机制，每次从内存中找到最久未使用的数据然后置换出来，
 * 从而存入新的数据！它的主要衡量指标是使用的时间，附加指标是使用的次数。
 */
public class LRU {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 0, 1, 2, 0, 3, 0, 5, 2, 3, 0, 3, 2};
        Node node = LRU(4, nums);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 双向列表，思路是查找队列中是否存在该值如果存在则删除当前值，将当前值插入到队尾。
     *
     * @param capacity 大小。
     * @param nums     数组。
     * @return 返回队列。
     */
    public static Node LRU(int capacity, int[] nums) {
        int count = 0;
        Node head = null;
        Node tail = null;

        for (int i = 0; i < nums.length; i++) {
            if (count < capacity) {
                Node node = new Node(nums[i]);
                if (count == 0) {
                    head = tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                count++;
            } else {
                Node pointer = head;
                boolean isDelete = false;
                while (pointer != null) {
                    int value = pointer.value;
                    if (value == nums[i] && head != pointer && tail != pointer) {
                        Node prev = pointer.prev;
                        Node next = pointer.next;
                        next.prev = prev;
                        prev.next = next;
                        Node oldTail = tail;
                        tail.next = new Node(nums[i]);
                        tail.next.prev = tail;
                        tail = tail.next;
                        isDelete = true;
                        break;


                    } else if (value == nums[i] && head == pointer && tail != pointer) {
                        // 队列头部。
                        Node next = pointer.next;
                        next.prev = null;
                        pointer.next = null;
                        head = next;
                        tail.next = new Node(nums[i]);
                        tail.next.prev = tail;
                        tail = tail.next;
                        isDelete = true;
                        break;
                    } else if (value == nums[i] && head != pointer && tail == pointer) {
                        // 队尾部。
                        tail = pointer.prev;
                        pointer.prev = null;
                        tail.next = new Node(nums[i]);
                        tail.next.prev = tail;
                        tail = tail.next;
                        isDelete = true;
                        break;
                    }
                    pointer = pointer.next;
                }
                if (!isDelete) {
                    // 如果没有找到则直接替换第一个值。
                    Node next1 = head.next;
                    next1.prev = null;
                    head.next = null;
                    tail.next = new Node(nums[i]);
                    tail.next.prev = tail;
                    tail = tail.next;
                    head = next1;
                }
            }
        }
        return head;
    }

    /**
     * Node节点。
     */
    static class Node {
        int value;

        Node next;

        Node prev;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
