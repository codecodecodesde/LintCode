public class LintCode_474
{
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here 
        ArrayList<ParentTreeNode> pathA = getPath(A);
        ArrayList<ParentTreeNode> pathB = getPath(B);
        
        int i = pathA.size() - 1;
        int j = pathB.size() - 1;
        while(i >= 0 && j >= 0){
            if(pathA.get(i) != pathB.get(j)){
                return pathA.get(i + 1);
            }
            i--;
            j--;
        }
        return pathA.get(i + 1);
    }
    
    private ArrayList<ParentTreeNode> getPath(ParentTreeNode node){
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while(node!= null){
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}