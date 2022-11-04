class Solution {
 
    public String reverseVowels(String s) {
        
        if(s.length()==0 || s== null)
        {
            return s;
        }
        
        
        char[] chArr = s.toCharArray();
        
        int start =0,end=s.length()-1;
        
        while(start<end)
        {
            while(start<s.length()  && !isVowel(chArr[start]))
            {
                start++;
            }
            
            while(end>=0 && !isVowel(chArr[end]))
            {
                end--;
            }
            
            if(start<end)
            {
                swap(chArr ,start++,end--);
            }
        }
        
        return new String(chArr);
    } //t_O(N),S-O(N)
    
    void swap(char[] chArray, int left, int right)
    {
        char temp = chArray[left];
        chArray[left]=chArray[right];
        chArray[right]=temp;
    }
        
    boolean isVowel(char ch)
    {
        return (ch=='a') || (ch=='e') || (ch=='i') || (ch=='o') || (ch=='u') ||
            (ch=='A') || (ch=='E') || (ch=='I') || (ch=='O') || (ch=='U') ;
    }
    
}