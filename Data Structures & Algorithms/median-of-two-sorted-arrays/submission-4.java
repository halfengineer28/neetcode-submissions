class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int smallLength = nums1.length;
        int largeLength = nums2.length;
        int start = 0;
        int end = smallLength;
        int totalLength = smallLength + largeLength;
        int half = (totalLength + 1 ) / 2;

        while(start <= end){
            int mid = start + (end - start ) / 2;
            int middle = half-mid;

            int leftSmall = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int leftMax = mid == smallLength ? Integer.MAX_VALUE : nums1[mid];

            int rightSmall = middle == 0 ? Integer.MIN_VALUE : nums2[middle - 1];
            int rightMax = middle == largeLength ? Integer.MAX_VALUE : nums2[middle];

            if (leftSmall <= rightMax && rightSmall <= leftMax){
                if (totalLength % 2 == 1){
                    return Math.max(leftSmall, rightSmall);
                }else{
                    return (Math.max(leftSmall, rightSmall) + Math.min(rightMax, leftMax)) / 2.0;
                }
            }else if (leftSmall > rightMax){
                end = mid - 1;
            }else{
                start = mid + 1;
            }


        }
        return -1;
    }
}
