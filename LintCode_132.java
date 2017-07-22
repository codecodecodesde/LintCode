class TrieNode{
    public String str;
    public TrieNode[] children;
    public boolean hasWord;
    public TrieNode(){
        children = new TrieNode[26];
        str = "";
    }
}

class Trie{
    public TrieNode root = new TrieNode();
    public void add(String word){
        TrieNode p = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(p.children[c - 'a'] != null){
                p = p.children[c - 'a'];
            }else{
                TrieNode newNode = new TrieNode();
                p.children[c - 'a'] = newNode;
                p = newNode;
            }
            
            if(i == chars.length - 1){
                p.hasWord = true;
                p.str = word;
            }
        }
    }
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    private int row, col;
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        if(board.length == 0 || words.size() == 0){
            return result;
        }
        
        Trie dict = new Trie();
        for(String str : words){
            dict.add(str);
        }
        TrieNode p = dict.root;
        
        row = board.length;
        col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(board, i, j, p, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int index_x, int index_y, TrieNode p, ArrayList<String> result){
        if(p.hasWord == true){
            if(!result.contains(p.str)){
                result.add(p.str);
            }
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        char c = board[index_x][index_y];
        if(c == '#' || p.children[c - 'a'] == null){
            return;
        }
        for(int i = 0; i < 4; i++){
            int next_x = index_x + dx[i];
            int next_y = index_y + dy[i];
            if(next_x < 0 || next_x >= row || next_y < 0 || next_y >= col){
                continue;
            }

            board[index_x][index_y] = '#';
            dfs(board, next_x, next_y, p.children[c - 'a'], result);
            board[index_x][index_y] = c;
        }
    }
}