class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int dict[] = new int[26];
        for(int i=0;i<order.length();i++)
        {
            dict[order.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                int min = Math.min(words[i].length(),words[j].length());
                
                for(int k=0;k<min;k++)
                {
                    char ci = words[i].charAt(k);
                    char cj = words[j].charAt(k);
                    
                    if(dict[ci-'a'] < dict[cj-'a'])
                    {
                        break;
                    }
                    else if(dict[cj-'a'] < dict[ci-'a'])
                    {
                        return false;
                    }
                    else if( k==min-1 && (words[i].length() > words[j].length()) )
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}