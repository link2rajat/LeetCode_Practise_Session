/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
import java.util.Hashtable;

class LRUCache {

    class DoublyLinkedList{
        int key;
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;
    }
   
    DoublyLinkedList head;
    DoublyLinkedList tail;
    int size;
    int capacity;
    Hashtable<Integer,DoublyLinkedList> cache;
    
    void addNode(DoublyLinkedList node){
        node.prev=head;
        node.next=head.next;
        
        head.next.prev=node;
        head.next=node;
        
    }
    
    void removeNode(DoublyLinkedList node){
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList next = node.next;
        
        prev.next=next;
        next.prev=prev;
    }
    
    DoublyLinkedList removeTail(){
        DoublyLinkedList node = tail.prev;
        removeNode(node);
        return node;
    }
    
    void moveNode(DoublyLinkedList node){
        removeNode(node);
        addNode(node);
    }
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
        head = new DoublyLinkedList();
        tail = new DoublyLinkedList();
        cache = new   Hashtable<Integer,DoublyLinkedList>();
       
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        DoublyLinkedList node = cache.get(key);
        
        if(node==null){
            return -1;
        }
        moveNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
         DoublyLinkedList node= cache.get(key);
        
        if(node==null){
          DoublyLinkedList newNode = new DoublyLinkedList();
            newNode.key=key;
            newNode.value=value;
            cache.put(key,newNode);
            addNode(newNode);
            
            ++size;
            if(size>capacity){
                DoublyLinkedList tail =  removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
           node.value=value;
           moveNode(node);
        }
}
}
//T-O(1),S-O(n)
