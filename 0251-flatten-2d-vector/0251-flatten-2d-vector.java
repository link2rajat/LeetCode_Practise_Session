import java.util.NoSuchElementException;

class Vector2D {
    
    int[][] vector;
    int inner = 0;
    int outer = 0;
    public Vector2D(int[][] vec) {
        vector = vec;
    }//T-O(1),S-O(1)
    
    public int next() {
        
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        
        return vector[outer][inner++];
    }//T-O(V/N),S-O(1)
    
    void advanceToNextElement(){
        
        while(outer<vector.length && inner==vector[outer].length){
            inner = 0;
            outer++;
        }
    }//T-O(V/N),S-O(1)
    
    public boolean hasNext() {
        advanceToNextElement();
        
        return outer < vector.length;
    }//T-O(V/N),S-O(1)
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */