public class LintCode_624 {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        
        int minLength = s.length();
        while(!queue.isEmpty()){
            s = queue.poll();
            for(String sub : dict){
                int found = s.indexOf(sub);
                while(found != -1){
                    String newString = s.substring(0, found) +
                        s.substring(found + sub.length(), s.length());
                    if(!set.contains(newString)){
                        if(newString.length() < minLength){
                            minLength = newString.length();
                        }
                        queue.add(newString);
                        set.add(newString);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }
        return minLength;
    }
}