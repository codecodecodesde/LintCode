class TrieNode{
    public ArrayList<String> startWith;
    public TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
        startWith = new ArrayList<String>();
    }
}

class Trie{
    public TrieNode root = new TrieNode();
    public Trie(String[] words){
        for(String str: words){
            char[] chars = str.toCharArray();
            TrieNode p = root;
            for(int i = 0; i < chars.length; i++){
                char c = chars[i];
                if(p.children[c - 'a'] != null){
                    p = p.children[c - 'a'];
                }else{
                    TrieNode newNode = new TrieNode();
                    p.children[c - 'a'] = newNode;
                    p = newNode;
                }
                p.startWith.add(str);
            }
        }
    }
    
    public List<String> findByPrefix(String prefix){
        TrieNode p = root;
        List<String> ans = new ArrayList<>();
        char[] chars = prefix.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(p.children[c - 'a'] == null){
                return ans;
            }
            p = p.children[c - 'a'];
        }
        ans.addAll(p.startWith);
        return ans;
    }
}


public class Solution {
    /**
     * @param words a set of words without duplicates
     * @return all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // Write your code here
        List<List<String>> ans = new ArrayList<>();
        if(words.length == 0){
            return ans;
        }
        
        Trie dict = new Trie(words);
        int len = words[0].length();
        for(String str : words){
            List<String> ansBuilder = new ArrayList<>();
            ansBuilder.add(str);
            dfs(ans, ansBuilder, dict, len);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
        return ans;
    }
    
    private void dfs(List<List<String>> ans, List<String> ansBuilder, Trie dict, int len){
        if(ansBuilder.size() == len){
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }
        
        int id = ansBuilder.size();
        StringBuilder prefix = new StringBuilder();
        for(String s : ansBuilder){
            prefix.append(s.charAt(id));
        }
        
        
        for(String str : dict.findByPrefix(prefix.toString())){
            ansBuilder.add(str);
            dfs(ans, ansBuilder, dict, len);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
}