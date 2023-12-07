public class ZigzagIterator {
        List<List<Integer>> vectors = new ArrayList<>();
          LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        
        vectors.add(v1);
        vectors.add(v2);
        int index=0;
        for(List<Integer> vec:vectors){
        if(vec.size()>0)
            //index_to_vec,index_to_element
            queue.add(new Pair<Integer,Integer>(index,0));
           
            index++;
                
        }
    }

    public int next() {
        Pair<Integer,Integer> pointer = queue.removeFirst();
        Integer vecIdx= pointer.getKey();
        Integer elemIdx = pointer.getValue();
        Integer nextElemIdx = elemIdx+1;
        if(nextElemIdx<vectors.get(vecIdx).size()){
            queue.addLast(new Pair<>(vecIdx,nextElemIdx));
        }
        return vectors.get(vecIdx).get(elemIdx);
    }

    public boolean hasNext() {
        return queue.size()>0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */