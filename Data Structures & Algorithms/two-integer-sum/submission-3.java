class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int moreNeeded = target - nums[i];
            if (seen.containsKey(moreNeeded)){
                return new int [] {seen.get(moreNeeded), i};
            }
            seen.put(nums[i], i);
        }
        return new int [] {-1, -1};
    }
}
