public class LintCode_120 {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        if(start.equals(end)){
            return 1;
        }
       
        Map<String, Set<String>> graph = new HashMap<>();
        dict.add(start);
        dict.add(end);

        for(String str : dict){
            graph.put(str, new HashSet<String>());
        }

        for(String str1 : dict){
            for(String str2: dict){
                if(oneLetter(str1, str2)){
                    graph.get(str1).add(str2);
                    graph.get(str2).add(str1);
                }
            }
        }
       
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
       
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++){
                String next = queue.poll();
                for(String str : graph.get(next)){
                    if(hash.contains(str)){
                        continue;
                    }
                    if(str.equals(end)){
                        return count;
                    }
                    queue.offer(str);
                    hash.add(str);
                }
            }
        }
        return 0;
       
    }
    
    private boolean oneLetter(String str1, String str2){
        if(str1.equals(str2)){
            return false;
        }
        
        int difference = 0;
        for(int i = 0; i < str1.length(); i++){
           if(str1.charAt(i) != str2.charAt(i)){
               difference++;
           }
            if(difference > 1){
                return false;
            }
        }
        
        return true;
    }
}