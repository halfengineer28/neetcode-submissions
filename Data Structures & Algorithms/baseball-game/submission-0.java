class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String s : operations){
            if ( s.equals("+") ){
                int a = stack.pop();
                int b = stack.pop();
                int c = a + b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }else if(s.equals("C")){
                stack.pop();
            }else if (s.equals("D")){
                int a = stack.peek();
                
                stack.push(2 * a);
            }else{
                int x = Integer.parseInt(s);
                stack.push(x);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}