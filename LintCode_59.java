public class LintCode_59 {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        int bestsum = numbers[0] + numbers[1] + numbers[2];
        for(int i = 0; i < numbers.length; i++){
            int start = i + 1, end = numbers.length - 1;
            while(start < end){
                int sum = numbers[i] + numbers[start] + numbers[end];
                if(Math.abs(sum - target) < Math.abs(bestsum - target)){
                    bestsum = sum;
                }
                if(sum > target){
                    end--;
                }
                else if(sum < target){
                    start++;
                }
                else{
                    return sum;
                }
            }
        }
        return bestsum;
    }
}