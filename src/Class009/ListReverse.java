package Class009;

public class ListReverse {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int v) {
            value = v;
        }

        public static DoubleListNode reverseDoubleList(DoubleListNode head) {
            DoubleListNode pre = null;
            DoubleListNode cur = head;
            DoubleListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                cur.last = next;
                pre = cur;
                next = cur;
            }
            return pre;
        }
    }
}
