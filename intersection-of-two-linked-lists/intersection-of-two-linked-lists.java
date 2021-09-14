/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ///// By Using two pointers
    // first fix the values for pointers
    ListNode ptr1= headA, ptr2= headB;
    if(ptr1== null || ptr2==null) return null;
    while(ptr1!= ptr2){
        // move pointers by one place until one list reaches to null
        ptr1=ptr1.next;
        ptr2=ptr2.next;
        // if listA has overlapping intersection of listB then return intersection point.
        if(ptr1==ptr2) return ptr1;
        // else reach the end on smaller list and change pointer to head of larger list
        if(ptr1==null)
            ptr1= headB;
        // the bigger list also get transversed and reaches null. Now, change pointer to
        // head of smaller list.
        if(ptr2==null)
            ptr2=headA; 
      }   
        return ptr1;
    }
}