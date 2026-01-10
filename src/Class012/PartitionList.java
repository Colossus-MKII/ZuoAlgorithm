package Class012;


public class PartitionList {
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
        public static ListNode partition (ListNode head, int x) {
            ListNode head1 = new ListNode(0);
            ListNode head2 = new ListNode(0);
            ListNode cur = head, cur1 = head1, cur2 = head2;
            while (cur != null) {
                if (cur.val < x) {
                    cur1.next = cur;
                    cur1 = cur1.next;
                } else {
                    cur2.next = cur;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            cur2.next = null;
            cur1.next = head2.next;
            return head1.next;
        }
    }
}
