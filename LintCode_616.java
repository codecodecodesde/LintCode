public class LintCode_616 {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] conditions = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            conditions[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            conditions[v].add(u);
            indegree[u]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
    
        int index = 0;
        while(!queue.isEmpty()){
            int head = (int)queue.poll();
            result[index] = head;
            index++;
            for(int j = 0; j < conditions[head].size(); j++){
                int num =(int) conditions[head].get(j);
                indegree[num]--;
                if(indegree[num] == 0){
                    queue.offer(num);
                }
            }
        }
        
        if(index == numCourses){
            return result;
        }
        return new int[0];
        
    }
}