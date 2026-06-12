class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;

        
    }
    public void mergeSort(int [] nums, int left, int right){
        if (left >= right){
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, mid + 1, right);
        mergeSort(nums, left, mid);

        merge(nums, left, mid, right);

    }
    public void merge(int [] nums, int left, int mid, int right){
        int [] temp = new int [right-left+1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid &&  j <= right){
            if (nums[i] <= nums[j]){
                temp[k] = nums[i];
                k++;
                i++; 
            }else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }

        while (i <= mid){
            temp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= right){
            temp[k] = nums[j];
            k++;
            j++;
        }
        
       for (int l = 0; l < temp.length;  l++){
            nums[left+l] = temp[l];
       }
    }
    
}