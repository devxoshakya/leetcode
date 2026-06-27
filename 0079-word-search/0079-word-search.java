class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exist(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, int idx){
        if( i < 0 || j < 0 || i >= board.length ||  j >= board[0].length || word.charAt(idx) != board[i][j] 
        || board[i][j] == '#' ) {
            return false;
        }

        if(idx == word.length()-1) return true;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean result = exist(board,word,i+1,j,idx+1) ||  exist(board,word,i,j+1,idx+1) || exist(board,word,i-1,j,idx+1) || exist(board,word,i,j-1,idx+1);

        board[i][j] = temp;
        return result;
    }
}