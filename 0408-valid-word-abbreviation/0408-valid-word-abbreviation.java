class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
          if(word==null || abbr==null)
            return false;
        int i=0,j=0;
        int wLength= word.length();
        int aLength= abbr.length();
        while(i<wLength && j<aLength){
            char a = word.charAt(i); 
            char b = abbr.charAt(j);
            if(a==b){
                i++;
                j++;
            }else if(Character.isDigit(abbr.charAt(j)) && abbr.charAt(j) !='0' ){
                int digitLength=0;
                    while(j<aLength && Character.isDigit(abbr.charAt(j))){
                        digitLength=10*digitLength+((abbr.charAt(j))-'0');
                        j++;
                    }
                    i+=digitLength;
                } else {
                return false;
                }
          }
           return i==wLength && j==aLength;
    }
}