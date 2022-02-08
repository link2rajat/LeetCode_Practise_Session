class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
    if(!wordList.contains(endWord))
    {
        return 0;
    }
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level=1;
        Set<String> dict = new HashSet<String>(wordList);
 
        while(!queue.isEmpty())
        {
            int levelsize = queue.size();
            for(int li =0;li<levelsize;li++)
            {
                String word = queue.poll();
                char[] currentWord = word.toCharArray();
                
                for(int charcount =0;charcount<currentWord.length;charcount++)
                {     char temp  =currentWord[charcount] ;
                    for(char ch ='a';ch<='z';ch++)
                    {
                        currentWord[charcount] = ch;
                        String newWord = new String(currentWord);
                        if(dict.contains(newWord))
                        {
                          if(newWord.equals(endWord))
                            return level+1; 
                            queue.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                   currentWord[charcount] = temp;
                }
            }
            level++;
        }
        return 0; 
    }
}//T-O(m^2*n),S-O(m^2*n)