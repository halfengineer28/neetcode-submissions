class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }
                if (set.contains(ch)){
                    return false;
                }
                set.add(ch);


            }
        }

        for (int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++){
              char ch = board[j][i];
              if (ch == '.'){
                continue;
              }
               if (set.contains(ch)){
                return false;
              }

              set.add(ch);
            }
        }

        for (int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                     int row = (i / 3 )*  3 + j;
                     int col = (i % 3) * 3 + k;
                     char ch = board[row][col];
                     if (ch == '.'){
                        continue;
                     }
                      if (set.contains(ch)){
                        return false;
                     }
                     set.add(ch);
                }

            }
        }
        return true;
        
    }
}
