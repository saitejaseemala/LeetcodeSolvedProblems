class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        while(first != null && first.next != null) {
            if(first.val == first.next.val) first.next = first.next.next;
            else first = first.next;
        }
        return head;
    }
}