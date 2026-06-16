class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int start = weights[0];
    int end = weights[0];

    for (int i = 1; i < weights.length; i++) {
      start = Math.max(start, weights[i]);
      end += weights[i];
    }
    int ans = end;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (canShip(weights, days, mid) ){
        ans = Math.min(ans, mid);
        end = mid-1;
      }else{
        start = mid + 1;

      }

    }
    return ans;
  }
  public boolean canShip(int[] nums, int day, int mid) {
    int shipped = mid;
    int count = 1;

    for (int num : nums) {
      if (shipped - num < 0) {
        count++;
        if (count > day) {
          return false;
        }
        shipped = mid;
      }
      shipped -= num;
    }
    return true;
  }
}