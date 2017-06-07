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

public class LintCode_120_2 {
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
       
        dict.add(start);
        dict.add(end);

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
                for(String str : getNext(next, dict)){
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
    
    private ArrayList<String> getNext(String target, Set<String> dict){
        ArrayList<String> candidates = new ArrayList<>();
        for(char c = 'a'; c < 'z'; c++){
            for(int i = 0; i < target.length(); i++){
                if(c == target.charAt(i)){
                    continue;
                }
                String replaced = replace(target, c, i);
                if(dict.contains(replaced)){
                    candidates.add(replaced);
                }
            }
        }
       return candidates;
    }
    
    private String replace(String word, char c, int position){
       char[] chars = word.toCharArray();
       chars[position] = c;
       return new String(chars);
    }
  
}

public class LintCode_120_3 {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}