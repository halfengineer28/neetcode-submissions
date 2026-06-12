class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    // [ -4, -1, -1, 0, 1, 2 ]

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j-1] == nums[j]){
            continue;
        }
        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
          long sum = nums[i] + nums[j];
          sum += nums[left];
          sum  +=  nums[right];
          if (sum == target) {
            List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
        
                ans.add(temp);
            

            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }

          } else if (sum > target) {
            right--;
          } else {
            left++;
          }
        }
      }
    }
    return ans;
  }
}