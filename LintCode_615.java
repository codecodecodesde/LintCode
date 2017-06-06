public class LintCode_615{
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] requisites = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            requisites[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            requisites[v].add(u);
            indegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int head = (int)queue.poll();
            count++;
            for(int i = 0; i < requisites[head].size(); i++){
                int num = (int)requisites[head].get(i);
                indegree[num]--;
                if(indegree[num] == 0){
                    queue.offer(num);
                }
            }
        }
        
        return count == numCourses;
    }
}