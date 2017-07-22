class TrieNode{
    public TrieNode[] children;
    public boolean hasWord;
    public TrieNode(){
        children = new TrieNode[26];
    }
}

public class WordDictionary {
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode p = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(p.children[c - 'a'] != null){
                p = p.children[c - 'a'];
            }else{
                TrieNode newNode = new TrieNode();
                p.children[c - 'a'] = newNode;;
                p = newNode;
            }
            if(i == chars.length - 1){
                p.hasWord = true;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        TrieNode p = root;
        return dfs(word, 0, p);
    }
    
     private boolean dfs(String word, int index, TrieNode p){
         if(index == word.length()){
             return p.hasWord;
         }
         
         char c = word.charAt(index);
         if(c == '.'){
             for(int i = 0; i < 26; i++){
                 if(p.children[i] != null){
                    if(dfs(word, index + 1, p.children[i])){
                        return true;
                    }
                 }
             }
             return false;
         }else if(p.children[c - 'a'] != null){
             if(dfs(word, index + 1, p.children[c - 'a'])){
                 return true;
             }
             return false;
         }else{
             return false;
         }
     }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");