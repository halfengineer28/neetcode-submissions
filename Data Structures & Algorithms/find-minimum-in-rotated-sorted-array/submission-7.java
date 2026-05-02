class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;

        while (start <= end){
            if (nums[start] < nums[end]){
                min = Math.min(min, nums[start]);
            }

            int mid = start + (end - start) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[start] <= nums[mid]){
                start =  mid + 1;
            }else{
                end = mid;
            }
        }
        return min;
        
    }
}
