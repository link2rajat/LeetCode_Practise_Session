class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       if(!wordList.contains(endWord)){
           return 0;
       } 
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int levels=1;
        Set<String> dictSet = new HashSet<String>(wordList);
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int level=0;level<levelSize;level++){
                String word = queue.poll();
                char[] currentWord = word.toCharArray();
                for(int charCount=0;charCount<currentWord.length;charCount++){
                    char temp = currentWord[charCount];
                    for(char ch='a';ch<='z';ch++){
                         currentWord[charCount]=ch;
                         String newWord = new String(currentWord);
                        if(dictSet.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return levels+1;
                            }
                            queue.add(newWord);
                            dictSet.remove(newWord);
                        }
                    }
                   currentWord[charCount]= temp;
                }
            }
            levels++;
        }
        return 0;
    }
}