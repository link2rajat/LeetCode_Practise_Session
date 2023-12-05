class Solution {
    public List<String> letterCombinations(String digits) {
     
        List<String> combinations = new ArrayList<>();
        if(digits.length()==0 || digits==null){
            return combinations;
        }
         Map<Character,String> combinationMap = Map.of('2',"abc",'3',"def",'4',"ghi",
         '5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
        
        backtrack(0,new StringBuilder(),combinations,digits,combinationMap);

        return combinations;
        
    }
    
    void backtrack(int index,StringBuilder current,List<String> combinations,String digits, Map<Character,String> combinationMap){
        
        if(digits.length()==index){
            combinations.add(current.toString());
            return;
        }

        String charCombination = combinationMap.get(digits.charAt(index));
        
        for(char neighbourChar :charCombination.toCharArray()){
                current.append(neighbourChar);
                backtrack(index+1,current,combinations,digits,combinationMap);
                current.deleteCharAt(current.length()-1);
        }
    }
}