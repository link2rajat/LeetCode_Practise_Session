class SmallestInfiniteSet {
    SortedSet<Integer> addIntSet;
    Integer currentInt;
    public SmallestInfiniteSet() {
     addIntSet = new TreeSet<>();
        currentInt = 1;
    }
    
    public int popSmallest() {
        int ans;
        if(!addIntSet.isEmpty()){
            ans = addIntSet.first();
            addIntSet.remove(ans);
        }else{
            ans = currentInt;
            currentInt+=1;
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(currentInt<= num || addIntSet.contains(num)){
            return;
        }
       addIntSet.add(num); 
    }
}//T-O((m+n)log n),S-O(n)

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */