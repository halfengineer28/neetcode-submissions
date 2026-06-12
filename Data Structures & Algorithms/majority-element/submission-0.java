class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = n / 2;

        int cnt = 0;
        int maxEle = 0;

        for (int i = 0; i < nums.length; i++){
            if (cnt == 0){
                maxEle = nums[i];
                cnt = 1;
            }

            if (nums[i] == maxEle){
                cnt++;

            }else{
                cnt--;
            }
        }
        cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == maxEle){
                cnt++;
            }
        }

        if (cnt >= majority){
            return maxEle;
        }

        return -1;
        
    }
}