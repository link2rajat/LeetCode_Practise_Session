public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs)
        {
         sb.append(str.length()).append('#').append(str);
        }
        
        return sb.toString();
        
    }
//T-O(n),S-O(n)
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    
        List<String> stList = new ArrayList<>();
        
        int index=0;
        
        while(index<s.length())
        { 
            int hash = s.indexOf('#',index);
            int sLength = Integer.valueOf(s.substring(index,hash));
            index=hash+sLength+1;
            stList.add(s.substring(hash+1,index));
        }
        return stList;
    }
}
//T-O(n^2),S-O(n)


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));