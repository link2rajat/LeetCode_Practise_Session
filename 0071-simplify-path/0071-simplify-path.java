class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
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
        StringBuilder sb = new StringBuilder();
        
        for(String s: stack){
            sb.append("/");
            sb.append(s);
        }
        
        return sb.length()>0 ? sb.toString() : "/";
    }
}