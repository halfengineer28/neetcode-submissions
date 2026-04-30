class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int start = 0;
        int end = ROWS*COLS-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if(target < matrix[row][col]){
                end = mid - 1;
            }else if(target > matrix[row][col]){
                start = mid + 1;
            }else{
                return true;
            }
        }
        return false;
        
    }
}
