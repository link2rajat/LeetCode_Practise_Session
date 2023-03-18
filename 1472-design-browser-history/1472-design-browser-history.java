class DLLNode{
    
    String data;
    DLLNode prev, next;
    
    DLLNode(String url){
        data = url;
        prev = null;
        next = null;
    }
};

class BrowserHistory {
    DLLNode linkedListHead;
    DLLNode current; 

    public BrowserHistory(String homepage) {
        
        linkedListHead = new DLLNode(homepage);
        current = linkedListHead;
    }
    
    public void visit(String url) {
        DLLNode newNode = new DLLNode(url);
        current.next = newNode;
        newNode.prev = current;
        
        current = newNode;
    }
    
    public String back(int steps) {
        
        while(steps>0 && current.prev != null){
            current = current.prev;
            steps--;
        }
        return current.data;
    }
    
    public String forward(int steps) {
        
        while(steps>0 && current.next != null){
            current = current.next;
            steps--;
        }
        return current.data;
    }
}//T-O(l),S-O(l*n)

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */