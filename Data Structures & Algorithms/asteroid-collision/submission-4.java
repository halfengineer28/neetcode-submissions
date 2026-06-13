class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> stack = new Stack();

        for (int a : asteroids){
            boolean destory = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0){
                int top = stack.peek();
                int b = Math.abs(a);

                if (top < b){
                    stack.pop();

                }else if (top == b){
                    stack.pop();
                    destory = true;
                    break;
                }else{
                    destory = true;
                    break;
                }
            }

            if (!destory){
                stack.push(a);
            }


        }

        int [] ans = new int [stack.size()];
        for (int i = stack.size()-1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;

        
    }
}