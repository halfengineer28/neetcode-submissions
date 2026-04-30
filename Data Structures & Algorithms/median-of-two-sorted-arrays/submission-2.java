class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A = nums1;
        int [] B = nums2;
        int total = A.length + B.length;
        if(B.length < A.length){
            int [] temp = A;
             A = B;
             B = temp;
        }
        int half = (A.length + B.length + 1)/ 2;
        int l = 0;
        int r = A.length;
        while(l <= r){
            int mid1 = l + (r-l)/2;
            int mid2 = half-mid1;
            int leftA = mid1 > 0 ? A[mid1-1] : Integer.MIN_VALUE;
            int leftB = mid2 > 0 ? B[mid2-1] : Integer.MIN_VALUE;
            int rightA = mid1 < A.length ? A[mid1] : Integer.MAX_VALUE;
            int rightB = mid2 < B.length ? B[mid2] : Integer.MAX_VALUE;
            if(leftA <= rightB && leftB <= rightA){
                if(total % 2 != 0){
                    return Math.max(leftA, leftB);
                }
                return (Math.max(leftA, leftB) + Math.min(rightA, rightB))/2.0;
            }else if(leftA > rightB){
                r = mid1 - 1;
            }else {
                l = mid1 + 1;
            }
        }
        return -1;
    }
}
