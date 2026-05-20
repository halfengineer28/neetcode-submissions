class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int temp = currMax * num;

            currMax = Math.max(Math.max(num * currMax, num *currMin), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);

            res = Math.max(res, currMax);
        }
        
        return res;
    }
}
