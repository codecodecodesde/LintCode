public class LintCode_49 {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0){
            return;
        }
        
        int left = 0, right = chars.length - 1;
        while(left <= right){
            while(left <= right && chars[left] >= 'a' && chars[left] <= 'z'){
                left++;
            }
            while(left <= right && chars[right] >= 'A' && chars[right] <= 'Z'){
                right--;
            }
            
            if(left <= right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
    }
}