class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while(start <= end){
            int mid = start + (end - start)/2;
            long total = 0;
            for(int p : piles){
                 total += Math.ceil((double)p/mid);
            }
            if(total <= h){
                end = mid - 1;
            }else{ 
                start = mid + 1;
            }
        }
        return start;

        
    }
}
