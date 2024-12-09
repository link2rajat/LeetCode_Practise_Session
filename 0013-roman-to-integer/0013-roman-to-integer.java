class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chArray = s.toCharArray();
        int answer=0;
        
        for(int i=0;i<chArray.length-1;i++){
            if(map.get(chArray[i])>=map.get(chArray[i+1]))
            {
                answer+=map.get(chArray[i]);
            }else{
                answer-=map.get(chArray[i]);
            }
           
        }
        answer+=map.get(chArray[chArray.length-1]);
        return answer;
    }
}