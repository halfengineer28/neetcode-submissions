class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = m-1;

        while (i >= 0 && j >= 0 && k >= 0) {
            if (nums1[k] > nums2[j]) {
                int temp = nums1[k];
                nums1[k] = nums1[i];
                nums1[i] = temp;
                i--;
                k--;
            } else {
                
                nums1[i] = nums2[j];
                i--;
             
                j--;

            }
        }
        while (i >= 0 && j >= 0){
            nums1[i] = nums2[j];
            i--;
            j--;
        }
    }
}