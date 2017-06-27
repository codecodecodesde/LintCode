public class LintCode_58 {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(numbers == null || numbers.length == 0){
            return result;
        }
        
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 3; i++){
            if(i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            for(int j = i + 1; j < numbers.length - 2; j++){
                if(j > i + 1 && numbers[j] == numbers[j - 1]){
                    continue;
                }
                
                int start = j + 1, end = numbers.length - 1;
                int twoSum = target - numbers[i] - numbers[j];
                while(start < end){
                    int sum = numbers[start] + numbers[end];
                    if(sum == twoSum){
                        ArrayList<Integer> quadruplets = new ArrayList<>();
                        quadruplets.add(numbers[i]);
                        quadruplets.add(numbers[j]);
                        quadruplets.add(numbers[start]);
                        quadruplets.add(numbers[end]);
                        result.add(quadruplets);
                        start++;
                        end--;
                        while(start < end && numbers[start] == numbers[start - 1]){
                            start++;
                        }
                        while(start < end && numbers[end] == numbers[end + 1]){
                            end--;
                        }
                    }
                    else if(sum < twoSum){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}