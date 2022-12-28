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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1,head) ;
        ListNode ptr1 = dummyHead ;
        ListNode ptr2 = dummyHead ;
        
        while(n>0){
            n--;
            ptr2 = ptr2.next ;
        }
        
        while(ptr2.next != null){
            ptr1 = ptr1.next ;
            ptr2 = ptr2.next ;
        }
        ptr1.next = ptr1.next.next ;
        return dummyHead.next ;
    }
}