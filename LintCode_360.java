class Node implements Comparable<Node>{
    int id;
    int val;
    Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    public int compareTo(Node other) {
        Node a =(Node)other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(k == 0){
            return ans;
        }
        
        int smallerSize = (k + 1) / 2;
        TreeSet<Node> smaller = new TreeSet<>();
        TreeSet<Node> larger = new TreeSet<>();
        for(int i = 0; i < k - 1; i++){
            add(smaller, larger, smallerSize, new Node(i, nums[i]));
        }
        
        for(int i = k - 1; i < nums.length; i++){
            add(smaller, larger, smallerSize, new Node(i, nums[i]));
            ans.add(larger.last().val);
            remove(smaller, larger, new Node(i - k + 1, nums[i - k + 1]));
        }
        return ans;
    }
    
    private void add(TreeSet<Node> smaller, TreeSet<Node> larger, int size, Node node){
        if(larger.size() < size){
            larger.add(node);
        }else{
            smaller.add(node);
        }
        
        if(larger.size() == size){
            if(smaller.size() > 0 && smaller.first().val < larger.last().val){
                Node left = smaller.first();
                Node right = larger.last();
                smaller.remove(left);
                larger.remove(right);
                smaller.add(right);
                larger.add(left);
            }
        }
    }
    
    private void remove(TreeSet<Node> smaller, TreeSet<Node> larger, Node node){
        if(smaller.contains(node)){
            smaller.remove(node);
        }else{
            larger.remove(node);
        }
    }
}