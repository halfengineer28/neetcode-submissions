class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currsum = 0;

        for (int i = 0; i < nums.length; i++){

            if (currsum < 0){
                currsum = 0;
            }
            currsum = currsum + nums[i];
            ans = Math.max(ans, currsum);

        }
        return ans;
        
    }
}
