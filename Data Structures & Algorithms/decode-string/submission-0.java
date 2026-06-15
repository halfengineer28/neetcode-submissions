class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ']'){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")){
                    sb.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder len = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    len.insert(0, stack.pop());
                }

                int count = Integer.parseInt(len.toString());
                String ans = sb.toString().repeat(count);
                stack.push(ans);

        
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }

        return result.toString();
        
    }
}