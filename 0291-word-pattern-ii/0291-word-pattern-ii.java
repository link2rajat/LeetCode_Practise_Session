class Solution {
    Map<Character,String> map= new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        if(pattern.isEmpty())return s.isEmpty();
        if(map.containsKey(pattern.charAt(0))){
            String value=map.get(pattern.charAt(0));
            if(s.length()<value.length()||!s.substring(0,value.length()).equals(value))return false;
            if(wordPatternMatch(pattern.substring(1),s.substring(value.length())))return true;
        }else{
            for(int i=1;i<=s.length();i++){
                if(set.contains(s.substring(0,i)))continue;
                map.put(pattern.charAt(0),s.substring(0,i));
                set.add(s.substring(0,i));
                if(wordPatternMatch(pattern.substring(1),s.substring(i)))return true;
                set.remove(s.substring(0,i));
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}