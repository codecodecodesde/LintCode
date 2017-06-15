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