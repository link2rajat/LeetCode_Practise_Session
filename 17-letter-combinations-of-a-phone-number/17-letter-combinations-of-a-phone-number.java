class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<String>();
        
        if(digits== null || digits.equals(""))
        {
            return result;
        }
        Map<Character, char[]> letterCombinationMap = new HashMap<>();
        letterCombinationMap.put('0',new char[]{});
        letterCombinationMap.put('1',new char[]{});
        letterCombinationMap.put('2',new char[]{'a','b','c'});
        letterCombinationMap.put('3',new char[]{'d','e','f'});
        letterCombinationMap.put('4',new char[]{'g','h','i'});
        letterCombinationMap.put('5',new char[]{'j','k','l'});
        letterCombinationMap.put('6',new char[]{'m','n','o'});
        letterCombinationMap.put('7',new char[]{'p','q','r','s'});
        letterCombinationMap.put('8',new char[]{'t','u','v'});
        letterCombinationMap.put('9',new char[]{'w','x','y','z'});
        
        StringBuilder sb = new StringBuilder();
        helperletterCombinations(result,letterCombinationMap,sb,digits);
        return result;
    }
void   helperletterCombinations(List<String> result,Map<Character, char[]> letterCombinationMap,StringBuilder sb,String digits)
    {
        if(sb.length()== digits.length())
        {
            result.add(sb.toString());
            return;
        }
    else
    {
    for(char ch:letterCombinationMap.get(digits.charAt(sb.length())))
    {
        sb.append(ch);
         helperletterCombinations(result,letterCombinationMap,sb,digits);
         sb.deleteCharAt(sb.length()-1);
    }
    }    
    }
}