public class LintCode_124 {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < num.length; i++){
            set.add(num[i]);
        }
        
        int longest = 0;
        for(int i = 0; i < num.length; i++){
            int down = num[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            
            int up = num[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            
            longest = Math.max(up - down - 1, longest);
        }
        return longest;
    }
}