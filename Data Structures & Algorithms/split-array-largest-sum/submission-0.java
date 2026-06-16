class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int ans = 0;

        for (int num : nums){
            start = Math.max(start, num);
            end += num; 
        }
        ans = end;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (canSplit(nums,k, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean canSplit(int [] nums, int k, int mid){
        int count = 1;
        int total = mid;

        for (int num : nums){
            if(total - num < 0){
                count++;
                if (count > k){
                    return false;
                }

                total = mid;
            }
            total -= num;


        }
        return true;
    }
}