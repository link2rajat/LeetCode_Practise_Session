class Solution {
    public boolean halvesAreAlike(String s) {
        int n =s.length();
        
        String vowels = "aeiouAEIOU";
        
        int aVowelCount = 0;
        
        for(int i=0;i<n/2;i++){
            if(vowels.indexOf(s.charAt(i)) !=-1){
                aVowelCount++;
            }
        }
        
         int bVowelCount = 0;
        
        for(int i=n/2;i<n;i++){
            if(vowels.indexOf(s.charAt(i)) !=-1){
                bVowelCount++;
            }
        }
        
        return aVowelCount == bVowelCount;
            
    }
} //T-O(n),S-O(1)