class Solution {
    public int removeElement(int[] nums, int val) {
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val){
                k = i;
                break;
            }

        }
       if (k == Integer.MAX_VALUE){
        return nums.length;
       }

        for(int i = k + 1; i < nums.length; i++){
            if (nums[i] != val){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        return k;
    }
}