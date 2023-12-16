class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word==null || abbr==null)
            return false;
        int i=0,j=0;
        while(i<word.length() && j<abbr.length()){
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            
            if(c1==c2){
                i++;
                j++;
            }else if(Character.isDigit(c2) && c2 != '0'){
                int digitCount = 0;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j)) ){
                    digitCount=digitCount*10 + (abbr.charAt(j)-'0');
                    j++;
                }
                i+=digitCount;
            }else{
                return false;
            }
            
        }
        return i==word.length() && j==abbr.length();
    }
}