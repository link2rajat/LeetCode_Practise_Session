class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> counter = new HashMap();
        
        for(String word: words)
        {
            counter.put(word,counter.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (word1,word2)-> counter.get(word1).equals(counter.get(word2))?
             word2.compareTo(word1):counter.get(word1) - counter.get(word2));
         
        for(String word: counter.keySet())
        {
            heap.offer(word);
            if(heap.size()>k)heap.poll();
        }
        List<String> result = new ArrayList();
        
        while(!heap.isEmpty()) result.add(heap.poll());
        Collections.reverse(result);
        return result;
        
        
    }
}//T-O(nlogk),S-O(n)