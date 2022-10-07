class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()==0 || t.length()==0)
        {
            return "";
        }

        HashMap<Character,Integer> pattern = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
         int count = pattern.getOrDefault(t.charAt(i),0);
         pattern.put(t.charAt(i),count+1);
        }

        int foundLength = 0;
        int requiredLength = pattern.size();

        int[] arr = {-1,0,0};

        int l=0,r=0;

        HashMap<Character,Integer> window = new HashMap<>();

        while(r<s.length())
        {
            char ch = s.charAt(r);
            int count = window.getOrDefault(ch,0);
            window.put(ch,count+1);

        if(pattern.containsKey(ch) && window.get(ch).intValue()==pattern.get(ch).intValue())
            {
                foundLength++;
            }

            while(l<=r && foundLength==requiredLength)
            {
                ch = s.charAt(l);

                if(arr[0] == -1 || r-l+1<arr[0])
                {
                    arr[0]=r-l+1;
                    arr[1]=l;
                    arr[2]=r;
                }
        window.put(ch,window.get(ch)-1);

        if(pattern.containsKey(ch) && window.get(ch).intValue()<pattern.get(ch).intValue())
        {

            foundLength--;
        }
        l++;
            }

            r++;
        }

    return arr[0]==-1 ?"":s.substring(arr[1],arr[2]+1);

    }
}//T-O(S+T),S-O(S+T)S