public class LintCode_415 {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s.length() == 0){
            return true;
        }
        
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(!isValid(s.charAt(i))){
                i++;
                if(i == j){
                    return true;
                }
            }
            while(!isValid(s.charAt(j))){
                j--;
            }
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}