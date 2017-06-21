public class LintCode_548 {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums2 == null){
            return null;
        }
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
            else{
                map.put(nums1[i], 1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
            else{
                continue;
            }
        }
        
        int[] intersection = new int[result.size()];
        int index = 0;
        for(int i : result){
            intersection[index++] = i;
        }
        return intersection;
    }
}