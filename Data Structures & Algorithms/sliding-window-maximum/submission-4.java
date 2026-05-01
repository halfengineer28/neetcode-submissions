class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int l = 0;
        int r = 0;
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[n - k + 1];

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[r]) {
                dq.removeLast();
            }
            dq.add(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }
            if (r - l + 1 == k) {
                ans[i] = nums[dq.getFirst()];
                i++;
                l++;
            }
            r++;
        }
        return ans;
    }
}
