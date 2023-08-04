class Solution {
    public int lengthOfLastWord(String s) {
    if(s.length()==0 || s== null)
        return 0;
       String [] charArray = s.split(" ");

    return charArray[charArray.length-1].length();
    }
}