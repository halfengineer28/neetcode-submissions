class Solution {
    public String simplifyPath(String path) {
        String [] strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : strs){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!s.equals("") &&  !s.equals(".")){
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
      
    }
}