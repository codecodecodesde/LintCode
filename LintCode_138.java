public class LintCode_138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                result.add(map.get(sum) + 1);
                result.add(i);
                break;
            }
            map.put(sum, i);
        }
        return result;
    }
}