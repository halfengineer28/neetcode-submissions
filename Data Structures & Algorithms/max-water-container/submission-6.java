class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int maxArea = 0;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int height = Math.min(nums[left], nums[right]);
            int area = height * (right-left);
            maxArea = Math.max(maxArea, area);
            if (nums[left] <= nums[right]){
                left++;
            }else{
                right--;
            }
        } 
        return maxArea;
    }
}
