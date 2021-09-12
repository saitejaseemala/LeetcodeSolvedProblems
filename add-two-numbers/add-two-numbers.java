/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode res = new ListNode(0);
        ListNode itr = res;
        
        int sum = 0;
        
        while(temp1 != null || temp2 != null) {
            sum /= 10;
            
            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            
            itr.next = new ListNode(sum % 10);
            itr = itr.next;
        }
        if(sum / 10 == 1) {
            itr.next = new ListNode(1);
        }
        
        return res.next;
    }
    
}