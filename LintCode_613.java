public class LintCode_613 {
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> records = new HashMap<>();
        for(Record r : results){
            if(!records.containsKey(r.id)){
                records.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> PQ = records.get(r.id);
            if(PQ.size() < 5){
                PQ.add(r.score);
            }
            else{
                if(r.score > PQ.peek()){
                    PQ.poll();
                    PQ.add(r.score);
                }
            }
        }
        Map<Integer, Double> highFive = new HashMap<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : records.entrySet()){
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0.0;
            for(int i = 0; i < 5; i++){
                average += scores.poll();
            }
            average = average/5.0;
            highFive.put(id, average);
        } 
        return highFive;
    }
}