public class LintCode_57 {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(numbers == null || numbers.length < 3){
            return result;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++){
            if(i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            twoSum(numbers, i + 1, -numbers[i], result);
        }
        return result;
    }
    
    private void twoSum(int[] numbers, int start, int target, ArrayList<ArrayList<Integer>> result){
        int end = numbers.length - 1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(-target);
                triplet.add(numbers[start]);
                triplet.add(numbers[end]);
                result.add(triplet);
                start++;
                end--;
                while(start < end && numbers[start] == numbers[start - 1]){
                    start++;
                }
                while(start < end && numbers[end] == numbers[end + 1]){
                    end--;
                }
            }
            else if(sum > target){
                end--;
            }
            else{
                start++;
            }
        }
    }
}