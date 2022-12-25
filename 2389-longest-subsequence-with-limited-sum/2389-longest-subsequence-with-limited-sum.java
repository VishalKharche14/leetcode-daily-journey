class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1] ;
        }
        
        for(int i=0; i<queries.length; i++){
            int idx = Arrays.binarySearch(nums,queries[i]) ;
            if(idx < 0){
                idx++;
                idx*=-1;
                queries[i] = idx;
            }
            else queries[i] = idx+1;
        }
        
        return queries ;
    }
}