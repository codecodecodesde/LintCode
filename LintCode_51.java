public class LintCode_51 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		
		int length = nums.size();
		int biggerIndex = -1;
		for(int i = length - 2; i >= 0; i--){
		    if(nums.get(i) > nums.get(i + 1)){
		        biggerIndex = i;
		        break;
		    }
		}
		
		if(biggerIndex == -1){
		    Collections.reverse(nums);
		    return nums;
		}
		
		int smallerIndex = -1;
		for(int i = length - 1; i > biggerIndex; i--){
		    if(nums.get(i) < nums.get(biggerIndex)){
		        smallerIndex = i;
		        break;
		    }
		}

		swapItem(nums, biggerIndex, smallerIndex);
		swapList(nums, biggerIndex + 1, length - 1);
		return nums;
    }
    
    private void swapItem(ArrayList<Integer> nums, int start, int end){
        int tmp = (int)nums.get(start);
        nums.set(start, nums.get(end));
        nums.set(end, tmp);
    }
    
    private void swapList(ArrayList<Integer> nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            swapItem(nums, i, j);
        }
    }
}