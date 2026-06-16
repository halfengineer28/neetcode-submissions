/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        int start = 1;
        int end = length-2;
        int peak = 0;

        while (start <= end){
            int mid = start + (end - start) / 2;

            int left = mountainArr.get(mid-1);
            int m = mountainArr.get(mid);
            int right = mountainArr.get(mid + 1);

            if (left < m && m < right){
                start =  mid + 1;

            }else if (left > m && m > right){
                end = mid - 1;
            }else{
                peak = mid;
                break;
            }
        }

        start = 0;
        end = peak-1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);
            if (val < target){
                start = mid + 1;

            }else if (val > target){
                end = mid - 1;
            }else {
                return mid;
            }
        }

        start = peak;
        end = length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);
            if (val > target){
                start = mid + 1;
            }else if (val < target){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}