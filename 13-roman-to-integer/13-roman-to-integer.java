class Solution {
    public int romanToInt(String s) {
        if(s== null || s.equals(""))
        {
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] arr = s.toCharArray();   
        
      int number = 0;
        for(int i = 0 ;i < arr.length-1; i++)
        { 
            if(map.get(arr[i]) >= map.get(arr[i+1])){
                number = number + map.get(arr[i]);
            } else {
                number = number - map.get(arr[i]);  
            }            
        }
        //Last Char Addition
        number = number + map.get(arr[arr.length-1]);
     return number;
    }
        
      
        
    
}