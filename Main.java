package 两数相加;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))))))))));
        Solution solution = new Solution();
        solution.addTwoNumbers(node1,node2);
    }
}


 //* Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int flag = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = sum(l1,l2);
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        ListNode next3 = node;
        while(true){
            if(next1 == null && next2 == null){
                if(flag == 1){
                    next3.next = new ListNode(1);
                }
                break;
            }else if(next1 == null){
                next3.next = sum(next2);
                next2 = next2.next;
            }else if(next2 == null){
                next3.next = sum(next1);
                next1 = next1.next;
            }else{
                next3.next = sum(next1,next2);
                next1 = next1.next;
                next2 = next2.next;
            }

            next3 = next3.next;
        }
        return node;
    }

    public ListNode sum (ListNode node1, ListNode node2){
        int nodeVal = 0;
        if(node1.val + node2.val + flag >= 10){
            nodeVal = node1.val + node2.val + flag - 10;
            flag = 1;
        }else{
            nodeVal = node1.val + node2.val +flag;
            flag = 0;
        }
        return new ListNode(nodeVal);
    }

    public ListNode sum (ListNode node1){
        int nodeVal = 0;
        if(node1.val + flag >= 10){
            nodeVal = node1.val + flag - 10;
            flag = 1;
        }else{
            nodeVal = node1.val + flag;
            flag = 0;
        }
        return new ListNode(nodeVal);
    }
}