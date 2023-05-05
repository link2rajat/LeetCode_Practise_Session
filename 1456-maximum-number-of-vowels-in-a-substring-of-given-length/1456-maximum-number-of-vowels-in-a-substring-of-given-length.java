class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        
        int count=0;
        for(int i=0;i<k;i++){
            count+=vowelSet.contains(s.charAt(i)) ? 1:0;
        }
        int ans =count;
        for(int i=k;i<s.length();i++){
            count+=vowelSet.contains(s.charAt(i)) ? 1:0;
            count-=vowelSet.contains(s.charAt(i-k)) ? 1:0;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}//T-O(N),S-O(1)