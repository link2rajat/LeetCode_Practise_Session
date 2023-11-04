class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
     
        int[] frequencyMagazine = countFrequency(magazine);
        int[] frequencyRansomNote = countFrequency(ransomNote);
        int count=0;
        for(int i=0;i<26;i++){
            if(frequencyMagazine[i]<frequencyRansomNote[i]){
               return false;
            }
        }
        
        return true;
        
    }
    
    int[] countFrequency(String s){
        int[] frequency = new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }
        return frequency;
    }
}