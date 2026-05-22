class Solution {
    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0){
            return false;
        }

        int target = Arrays.stream(nums).sum() / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = nums.length-1; i >= 0; i--){
            Set<Integer> newSet = new HashSet<>();

            for (int d : set){
                if (d + nums[i] == target){
                    return true;
                }

                newSet.add(d + nums[i]);
                newSet.add(d);
            }

            set = newSet;

        }

        return false;
        
    }
}
