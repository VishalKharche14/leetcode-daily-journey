/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null ;
        
        //copying next Nodes first
        Node tempHead = head ;
        Node newHead = new Node(-1) ;
        Node tempNewHead = newHead ;
        
        Map<Node,Node> map = new HashMap<>() ;
        
        while(tempHead != null){
            tempNewHead.next = new Node(tempHead.val) ;
            map.put(tempHead,tempNewHead.next) ;
            tempHead = tempHead.next ;
            tempNewHead = tempNewHead.next ;
        }
        
        tempHead = head ;
        while(tempHead != null){
            map.get(tempHead).random = map.get(tempHead.random) ;
            tempHead = tempHead.next ;
        }
        
        return newHead.next ;
    }
}