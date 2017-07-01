public class LintCode_545 {
    
    private Queue<Integer> minPQ;
    private int k;
    public Solution(int k) {
        // initialize your data structure here.
        this.k = k;
        minPQ = new PriorityQueue<>(k);
    }
    
    //logk
    public void add(int num) {
        // Write your code here
        if(minPQ.size() < k){
            minPQ.add(num);
        }else{
            if(num > minPQ.peek()){
                minPQ.poll();
                minPQ.add(num);
            }
        }
    }
    
    //klogk
    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<>(minPQ);
        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }
}