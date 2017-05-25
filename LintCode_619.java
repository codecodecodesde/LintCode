public class LintCode_619 {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    private class ResultType{
        public int max_up, max_down, max_length;
        public ResultType(int length, int up, int down){
            this.max_length = length;
            this.max_up = up;
            this.max_down = down;
        }
    }
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).max_length;
    }
    
    private ResultType helper(MultiTreeNode root){
        if(root == null){
            return new ResultType(0, 0, 0);
        }
        
        ArrayList<ResultType> result = new ArrayList<ResultType>();
        for (MultiTreeNode node : root.children) {
            result.add(helper(node));
        }
        
        int up = 0, down = 0, length = 1;
        for (int i = 0; i < root.children.size(); i++){
            if (root.val + 1 == root.children.get(i).val)
                down = Math.max(down, result.get(i).max_down + 1);
            if (root.val - 1 == root.children.get(i).val)
                up = Math.max(up, result.get(i).max_up + 1);
            length = Math.max(length, result.get(i).max_length);
        }
        length = Math.max(up + down + 1, length);
        return new ResultType(length, up, down);
    }
}