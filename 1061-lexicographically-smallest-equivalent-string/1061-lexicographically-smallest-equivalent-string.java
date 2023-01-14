class Solution {
    int head[]= new int[26];
    
    int find(int x){
        if(head[x]==x)
            return x;

        return head[x] = find(head[x]);
    }
    
    void union(int x, int y){
        x=find(x);
        y=find(y);
        
        if(x==y){
            return;
        }
        if(x<y){
            head[y] = x;
        } else {
            head[x] = y;
        }
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        for(int i=0;i<26;i++){
            head[i]=i;
        }
        
        for(int i=0;i<s1.length();i++){
           union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        
        StringBuilder result = new StringBuilder();
        
        for(char c:baseStr.toCharArray()){
            result.append((char)(find(c-'a')+'a'));
        }
        return result.toString();
    }
}