//https://www.youtube.com/watch?v=W8WalXRwqrM&ab_channel=happygirlzt
class SnapshotArray {

    List<TreeMap<Integer,Integer>> listsofTreeMap; 
    int snap_Id;
    public SnapshotArray(int length) {
        listsofTreeMap = new ArrayList<>();
        for(int i=0;i<length;i++)
        {
            listsofTreeMap.add(new TreeMap<Integer,Integer>());
            listsofTreeMap.get(i).put(0,0);
        }
        snap_Id =0;
    }
    
    public void set(int index, int val) {
        listsofTreeMap.get(index).put(snap_Id,val);
    }
    
    public int snap() {
      return  snap_Id++;  
    }
    
    public int get(int index, int snap_id) {
        return listsofTreeMap.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();a
 * int param_3 = obj.get(index,snap_id);
 */