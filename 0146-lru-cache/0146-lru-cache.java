class LRUCache {

    public int capacity;
    public Node head;
    public Node tail;
    public HashMap<Integer, Node> map;

    public class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    public int get(int key){
        //if key is not present
        if(!map.containsKey(key)) return -1;
        //if key is present
        removeAndAdd(map.get(key));
        return map.get(key).value;
    }
    public void put(int key, int value){
        Node node = map.getOrDefault(key,new Node(key,value));
        if(map.containsKey(key)){
            node.value = value ;
            removeAndAdd(node);
        }
        else{
            if(map.size() >= capacity){
                map.remove(head.key);
                remove(head);
            }
            add(node);
            map.put(key,node);
        }
    }
    private void removeAndAdd(Node node){
            if(node.key == tail.key){
                return;
            }
            remove(node);
            add(node);
        }
        private void remove(Node node){
            if(node.key == head.key){
                head = head.next ;
                if(head == null){
                    tail = null;
                    return;
                }
                head.prev = null ;
                node.next = null ;
            }
            else{
                Node prevNode = node.prev ;
                Node nextNode = node.next ;

                prevNode.next = nextNode ;
                nextNode.prev = prevNode ;

                node.next = node.prev = null ;
                // node.prev = null ;
            }
        }
        private void add(Node node){
            if(head == null && tail == null){
                head = tail = node ;
                return ;
            }
            tail.next = node ;
            node.prev = tail ;
            tail = tail.next ;
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */