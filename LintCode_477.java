public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    private int n, m;
    public void surroundedRegions(char[][] board) {
        // Write your code here
        n = board.length;
        if(n == 0){
            return;
        }
        m = board[0].length;
        for(int i = 0; i < n; i++){
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }
        
        for(int i = 0; i < m; i++){
            bfs(board, 0, i);
            bfs(board, n - 1, i);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'W'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int i, int j){
        if(board[i][j] != 'O'){
            return;
        }
        
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();
        queue_x.offer(i);
        queue_y.offer(j);
        board[i][j] = 'W';
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while(!queue_x.isEmpty()){
            int x = queue_x.poll();
            int y = queue_y.poll();
            for(int t = 0; t < 4; t++){
                int nx = x + dx[t];
                int ny = y + dy[t];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if(board[nx][ny] == 'O'){
                    queue_x.offer(nx);
                    queue_y.offer(ny);
                    board[nx][ny] = 'W';
                }
            }
        }
    }
}