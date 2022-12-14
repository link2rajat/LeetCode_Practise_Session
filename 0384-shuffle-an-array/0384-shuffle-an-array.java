class Solution {
    int[] array;
    int[] original;
    
    Random rand = new Random();
    
    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            swap(i, randomRange(i,array.length));
        }
        return array;
    }

    int randomRange(int min, int max){
        return rand.nextInt(max-min)+min;
    }
                 
    void swap(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }             
}//T-O(n),S-O(n)

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */