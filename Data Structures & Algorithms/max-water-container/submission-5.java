class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int start = 0;
        int end = n-1;
        int maxarea = 0;

        while (start <= end){
            int height = Math.min(heights[start], heights[end]);
            int area = height * (end - start);
            maxarea = Math.max(maxarea, area);
            if (heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxarea;
    }
}
