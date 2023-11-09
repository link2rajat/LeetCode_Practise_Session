class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        
        for(String directory:components){
           
            if(directory.equals(".") || directory.isEmpty()){
                continue;
            }else if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(directory);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(String s:stack){
            result.append("/");
            result.append(s);

        }
        return result.length()>0? result.toString():"/";
        
    }
}