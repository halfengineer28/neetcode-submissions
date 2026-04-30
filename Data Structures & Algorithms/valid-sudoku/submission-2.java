class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++){
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < m; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        for (int i = 0; i < n; i++){
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < m; j++){
                if (board[j][i] == '.'){
                    continue;
                }
                if (set.contains(board[j][i])){
                    return false;
                }

                set.add(board[j][i]);
            }
        }

        for (int i = 0; i < n; i++){
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    int r =  i / 3 * 3 + j;
                    int c =  i % 3 * 3 + k;
                    if (board[r][c] == '.'){
                        continue;
                    }
                    if (set.contains(board[r][c])){
                        return false;
                    }
                    set.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
