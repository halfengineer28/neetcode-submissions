class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] pse = new int [n];
        int [] nse = new int [n];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                pse[i] = stack.peek(); 
            }else{
                pse[i] = -1;
            }

            stack.push(i);


        }

        stack.clear();

        for (int i = n-1; i >= 0; i--){
            nse[i] = n;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                nse[i] = stack.peek();
            }

            stack.push(i);
        }


        for (int i = 0; i < n; i++){
            int width = nse[i]-pse[i]-1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);


        }
        return maxArea;
        
    }
}
