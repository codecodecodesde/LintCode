public class LintCode_605 {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        List[] conditions = new ArrayList[org.length + 1];
        int[] indegree = new int[org.length + 1];
        
        for(int i = 0; i < org.length + 1; i++){
            conditions[i] = new ArrayList<>();
        }
        
        int length = 0;
        for(int i = 0; i < seqs.length; i++){
            length = length + seqs[i].length;
            if (seqs[i].length >= 1 && (seqs[i][0] <= 0 || seqs[i][0] > org.length))
                return false;
            for(int j = 1; j < seqs[i].length; j++){
                if(seqs[i][j] <= 0 || seqs[i][j] > org.length){
                    return false;
                }
                int u = seqs[i][j - 1];
                int v = seqs[i][j];
                conditions[u].add(v);
                indegree[v]++;
            }
        }
        if(length < org.length){
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < org.length + 1; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(queue.size() == 1){
            int head = (int)queue.poll();
            count++;
            for(int i = 0; i < conditions[head].size(); i++){
                int course = (int)conditions[head].get(i);
                indegree[course]--;
                if(indegree[course] == 0){
                    queue.offer(course);
                }
            }
        }
        
        if(count != org.length){
            return false;
        }
        return true;
    }
}



public class LintCode_605_2 {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for(int num : org){
            map.put(num, new ArrayList<Integer>());
            indegree.put(num, 0);
        }
        
        int n = org.length;
        int lengthSum = 0;
        for(int[] seq : seqs){
            lengthSum += seq.length;
            if(seq.length >= 1 && (seq[0] < 1 || seq[0] > n)){
                return false;
            }
            for(int i = 1; i < seq.length; i++){
                if(seq[i] < 0 || seq[i] > n){
                    return false;
                }
                map.get(seq[i - 1]).add(seq[i]);
                indegree.put(seq[i], indegree.get(seq[i]) + 1);
            }
        }
        
        if(lengthSum < n){
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int num : org){
            if(indegree.get(num) == 0){
                queue.offer(num);
            }
        }
        
        int count = 0;
        while(queue.size() == 1){
            int first = (int)queue.poll();
            count++;
            for(int course : map.get(first)){
                indegree.put(course, indegree.get(course) - 1);
                if(indegree.get(course) == 0){
                    queue.offer(course);
                }
            }
        }
        
        return count == n;
    }
}