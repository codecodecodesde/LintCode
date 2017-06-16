public class LintCode_10 {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if(str == null){
            return result;
        }
        
        if(str.length() == 0){
            result.add(new String());
            return result;
        }
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        StringBuilder permutation = new StringBuilder();
        boolean[] visited = new boolean[str.length()];
        dfs(sortedString, result, permutation, visited);
        return result;
    }
    
    private void dfs(String str, List<String> result, StringBuilder permutation, boolean[] visited){
        if(permutation.length() == str.length()){
            String s = permutation.toString();
            result.add(s);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            if(visited[i] == true || (i > 0 && visited[i - 1] == false && str.charAt(i) == str.charAt(i - 1))){
                continue;
            }
            permutation.append(str.charAt(i));
            visited[i] = true;
            dfs(str, result, permutation, visited);
            visited[i] = false;
            permutation.deleteCharAt(permutation.length() - 1);
        }
    }
}