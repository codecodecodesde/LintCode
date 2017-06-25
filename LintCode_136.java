public class LintCode_136 {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        List<String> partition = new ArrayList<>();
        dfs(s, result, 0, partition);
        return result;
    }
    
    private void dfs(String s, List<List<String>> result, int startIndex, List<String> partition){
        if(startIndex == s.length()){
            result.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++){
            String substring = s.substring(startIndex, i + 1);
            if(!isPalindrome(substring)){
                continue;
            }
            partition.add(substring);
            dfs(s, result, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
        
    }
    
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        } 
        return true;
    }
}

public class LintCode_136_2 {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        
        isPalindrome = getPalindrome(s);
        List<String> partition = new ArrayList<>();
        dfs(s, result, 0, partition);
        return result;
    }
    private boolean[][] getPalindrome(String s){
        isPalindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        for(int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return isPalindrome;
        
    }
    private void dfs(String s, List<List<String>> result, int startIndex, List<String> partition) {
        if(startIndex == s.length()){
            result.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++){
            if(!isPalindrome[startIndex][i]){
                continue;
            }
            partition.add(s.substring(startIndex, i + 1));
            dfs(s, result, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
        
    }
}