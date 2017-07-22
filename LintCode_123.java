public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    private int row, col;
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board.length == 0){
            return false;
        }
        if(word.length() == 0){
            return true;
        }
        
        row = board.length;
        col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    board[i][j] = '#';
                    if(dfs(word, i, j, board, 1)){
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private boolean dfs(String word, int index_x, int index_y, char[][] board, int startIndex){
        if(startIndex == word.length()){
            return true;
        }
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        char c = word.charAt(startIndex);
        for(int j = 0; j < 4; j++){
            int next_x = index_x + dx[j];
            int next_y = index_y + dy[j];
            if(next_x < 0 || next_x >= row || next_y < 0 || next_y >= col){
                continue;
            }
            if(board[next_x][next_y] == c){
                board[next_x][next_y] = '#';
                if(dfs(word, next_x, next_y, board, startIndex + 1)){
                    return true;
                }
                board[next_x][next_y] = c;
            }
        }
        return false;
    }
}