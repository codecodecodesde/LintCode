class LintCode_544 {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        int kth = quickSelect(nums, 0, nums.length - 1, k);
        int[] result = new int[k];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= kth && index < k){
                result[index++] = nums[i];
            }
        }

        Arrays.sort(result);
        reverse(result);
        return result;
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }
        
        int left = start, right = end;
        int privot = nums[(start + end) / 2];
        while(left <= right){
            while(left <= right && nums[left] > privot){
                left++;
            }
            while(left <= right && nums[right] < privot){
                right--;
            }
            
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if(start + k - 1 <= right){
            return quickSelect(nums, start, right, k);
        }
        if(start + k - 1 >= right){
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
    
    private void reverse(int[] nums){
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}