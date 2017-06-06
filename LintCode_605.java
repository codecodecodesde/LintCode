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