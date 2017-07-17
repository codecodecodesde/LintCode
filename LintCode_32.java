public class LintCode_32 {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        String minStr = "";
        
        int[] sourcemap = new int[256];
        int[] targetmap = new int[256];
        
        for(char c : target.toCharArray()){
            targetmap[c]++;
        }
        
        int j = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0 ; i < source.length(); i++){
            while(j < source.length() && !isValid(sourcemap, targetmap)){
                sourcemap[source.charAt(j)]++;
                j++;
            }
            if(isValid(sourcemap, targetmap) && length > j - i){
                minStr = source.substring(i, j);
                length = Math.min(length, j - i);
            }
            sourcemap[source.charAt(i)]--;
        }
        return minStr;
    }
    
    private boolean isValid(int[] sourcemap, int[] targetmap){
        for(int i = 0; i < targetmap.length; i++){
            if(targetmap[i] > sourcemap[i]){
                return false;
            }
        }
        return true;
    }
}