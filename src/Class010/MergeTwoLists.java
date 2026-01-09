package Class010;

public class MergeTwoLists {
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

        class Solution {
            public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
                if (head1 == null) {
                    return head2;
                }
                if (head2 == null) {
                    return head1;
                }
                ListNode dummy = new ListNode(0);
                ListNode cur = dummy, cur1 = head1, cur2 = head2;
                while (cur1 != null && cur2 != null) {
                    if (cur1.val <= cur2.val) {
                        cur.next = cur1;
                        cur1 = cur1.next;
                        cur = cur.next;
                    } else {
                        cur.next = cur2;
                        cur2 = cur2.next;
                        cur = cur.next;
                    }
                }
                if (cur1 != null) {
                    cur.next = cur1;
                }
                if (cur2 != null) {
                    cur.next = cur2;
                }
                return dummy.next;
            }
        }
    }
}
