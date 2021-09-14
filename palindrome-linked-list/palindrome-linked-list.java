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
    public boolean isPalindrome(ListNode head) {
      
        ListNode end = head;
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer>queue = new LinkedList<Integer>();
        while(end!=null)
        {
            stack.add(end.val);
            queue.add(end.val);
            end=end.next;
        }
        for(int i=0;i<stack.size();i++){
            if(stack.pop()!=queue.poll()){
                return false;
            }
        }
        return true;
    }
}