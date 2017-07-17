public class LintCode_386 {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(k == 0 || s == null || s.length() == 0){
            return 0;
        }
        
        if(k >= s.length()){
            return s.length();
        }
        int j = 0;
        int length = Integer.MIN_VALUE;
        int[] map = new int[256];
        for(int i = 0 ; i < s.length(); i++){
            while(j < s.length()){
                if(map[s.charAt(j)] > 0){
                    map[s.charAt(j)]++;
                }else{
                    if(distinctChar(map) == k){
                        break;
                    }else{
                       map[s.charAt(j)]++; 
                    }
                }
                j++;
            }
            length = Math.max(length, j - i);
            map[s.charAt(i)]--;
        }
        
        if(length == Integer.MIN_VALUE){
            return 0;
        }
        return length;
    }
    
    private int distinctChar(int[] map){
        int count = 0 ;
        for(int i = 0 ; i < 256; i++){
            if(map[i] > 0){
                count++;
            }
        }
        return count;
    }
}