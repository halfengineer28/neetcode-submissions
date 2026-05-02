class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int ans = 0;

        while (start <= end){
            int mid = start + (end - start) / 2;
            long total = 0;

            for (int pile : piles){
                total += Math.ceil((double) pile / mid);

            }
            if (total <= h){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

            
        }
        return ans;
        
    }
}
