class Element{
    public int row;
    public int col;
    public int val;
    public Element(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class LintCode_486 {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if(arrays == null || arrays.length == 0){
            return null;
        }
        
        PriorityQueue<Element> PQ = new PriorityQueue<>(arrays.length, comparator);
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){
                PQ.add(new Element(i, 0, arrays[i][0]));
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!PQ.isEmpty()){
            Element min = PQ.poll();
            int row = min.row;
            int col = min.col;
            result.add(min.val);
            if(col + 1 < arrays[row].length){
                PQ.add(new Element(row, col + 1, arrays[row][col + 1]));
            }
        }
        return result;
    }
    
    private Comparator<Element> comparator = new Comparator<Element>(){
        public int compare(Element e1, Element e2){
            if(e1.val > e2.val){
                return 1;
            }
            if(e1.val < e2.val){
                return -1;
            }
            return 0;
        }  
    };
}