public class LintCode_384 {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int j = 0;
        int length = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            length = Math.max(length, j - i);
            set.remove(s.charAt(i));
        }
        
        if(length == Integer.MIN_VALUE){
            return -1;
        }
        return length;
    }
}