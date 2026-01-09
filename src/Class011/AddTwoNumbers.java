package Class011;

public class AddTwoNumbers {
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
        public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy, cur1 = h1, cur2 = h2;
            int carry = 0;
            while (cur1 != null && cur2 != null) {
                int sum = cur1.val + cur2.val + carry;
                carry = sum / 10;
                ListNode newOne = new ListNode(sum % 10);
                cur.next = newOne;
                cur = newOne;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            while (cur1 != null) {
                int sum = cur1.val + carry;
                carry = sum / 10;
                ListNode newOne = new ListNode(sum % 10);
                cur.next = newOne;
                cur = newOne;
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                int sum = cur2.val + carry;
                carry = sum / 10;
                ListNode newOne = new ListNode(sum % 10);
                cur.next = newOne;
                cur = newOne;
                cur2 = cur2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
}
