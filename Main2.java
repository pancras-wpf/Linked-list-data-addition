package 两数相加;

public class Main2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))))))))));
        Solution2 solution2 = new Solution2();
        solution2.addTwoNumbers(node1,node2);
    }
}


//* Definition for singly-linked list.

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val; 
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }
}