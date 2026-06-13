class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            while(sum >= target){
                sum -= nums[left];
                minLength = Math.min(minLength, right - left +1);
                left++;
            }

            right++;

        }
        if (minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}