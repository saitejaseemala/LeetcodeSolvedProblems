/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;  //check if head is null 
        
		ListNode slow=head;  //slow pointer
        ListNode fast=head;  //fast pointer
        
		while(fast.next!=null && fast.next.next!=null)
		{
             slow=slow.next;
             fast=fast.next.next;
             
			 if (slow==fast)   //at any time if slow and fast are equal then there is loop
				 return true;
         }
        return false;
    }
    
}