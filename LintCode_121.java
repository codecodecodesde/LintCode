public class LintCode_121 {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here 
        Map<String, ArrayList<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        dict.add(start);
        dict.add(end);

        bfs(graph, distance, start, end, dict);
        
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        dfs(graph, path, start, end, distance, result);
        return result;
    }
    
    private void bfs(Map<String, ArrayList<String>> graph, Map<String, Integer> distance, String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);

        for(String s: dict){
            graph.put(s, new ArrayList<String>());
        }
        
        while(!queue.isEmpty()){
            String first = queue.poll();
            for(String next : getNext(first, dict)){
                graph.get(next).add(first);
                if(distance.containsKey(next)){
                    continue;
                }
                queue.offer(next);
                distance.put(next, distance.get(first) + 1);
            }
        }
    }
    
    private ArrayList<String> getNext(String str, Set<String> dict){
        ArrayList<String> candidates = new ArrayList<>();
        for(char c = 'a'; c >= 'a' && c <= 'z'; c++){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == c){
                    continue;
                }
                String newStr = replace(str, c, i);
                if(dict.contains(newStr)){
                    candidates.add(newStr);
                }
            }
        }
        return candidates;
    }
    
    private String replace(String str, char c, int index){
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private void dfs(Map<String, ArrayList<String>> graph, List<String> path, String crt, String end, Map<String, Integer> distance, List<List<String>> result ){

        path.add(crt);
        if(crt.equals(end)){
            result.add(new ArrayList<String>(path));
        }
        else{
            for(String next : graph.get(crt)){
                if(distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1){
                    dfs(graph, path, next, end, distance, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}