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
    public ListNode mergeKLists(ListNode[] a) {
        if(a.length==0) return null;
        ListNode head = a[0];
        for(int i=1; i<a.length; i++){
            head = merge(head,a[i]);
        }
        return head;
	}
    public ListNode merge(ListNode A, ListNode B) {
        
        if(A==null) return B;
        if(B==null) return A;

        ListNode head = new ListNode(0);
        ListNode tempHead = head;

        while(A!=null && B!=null){
            if(A.val<=B.val){
                tempHead.next = A;
                A=A.next;
                tempHead=tempHead.next;
            }
            else{
                tempHead.next=B;
                B=B.next;
                tempHead=tempHead.next;
            }
        }

        if(A==null) tempHead.next = B;
        else if(B==null) tempHead.next = A;

        return head.next;
    }
}