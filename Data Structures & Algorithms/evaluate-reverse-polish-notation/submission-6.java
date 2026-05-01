class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){

            if (s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);


            }else if (s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);

            }else if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);

            }else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);

            }else{
                int a = Integer.parseInt(s);
                stack.push(a);

            }
        }
        return stack.peek();
    }
}
