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

public class LintCode_10_2{
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        char[] s = str.toCharArray();
        Arrays.sort(s);
        result.add(String.valueOf(s));
        while ((s = nextPermutation(s)) != null) {
            result.add(String.valueOf(s));
        }
        return result;
    }
    
    private char[] nextPermutation(char[] s){
        int smaller = -1;
        for(int i = s.length - 2; i >= 0; i--){
            if(s[i] < s[i + 1]){
                smaller = i;
                break;
            }
        }
        
        if(smaller == -1){
            return null;
        }
        
        int bigger = -1;
        for(int i = s.length - 1; i  > smaller; i--){
            if(s[i] > s[smaller]){
                bigger = i;
                break;
            }
        }
        
        swap(s, smaller, bigger);
        swapList(s, smaller + 1, s.length - 1);
        return s;
    }
    
    private void swap(char[] s, int start, int end){
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
    
    private void swapList(char[] s, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            swap(s, i, j);
        }
    }
}