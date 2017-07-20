/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public char c;
    public Map<Character, TrieNode> children;
    public boolean hasWord;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode(char c){
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(p.children.containsKey(c)){
                p = p.children.get(c);
            }else{
                TrieNode newNode = new TrieNode(c);
                p.children.put(c, newNode);
                p = newNode;
            }
            if(i == chars.length - 1){
                p.hasWord = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode last = findTrieNodePos(word);
        if(last == null){
            return false;
        }
        if(last.hasWord){
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(findTrieNodePos(prefix) == null){
            return false;
        }
        return true;
    }
    
    private TrieNode findTrieNodePos(String word){
        TrieNode p = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(p.children.containsKey(c)){
                p = p.children.get(c);
            }else{
                return null;
            }
        }
        return p;
    }
}