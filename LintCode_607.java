public class TwoSum {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    public TwoSum(){
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        list.add(number);
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }
        else{
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for(int i = 0; i < list.size(); i++){
            //System.out.println(value - list.get(i));
            if(list.get(i) == value - list.get(i)){
                if(map.get(value - list.get(i)) > 1){
                    return true;
                }
            }
            else if(map.containsKey(value - list.get(i))){
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);