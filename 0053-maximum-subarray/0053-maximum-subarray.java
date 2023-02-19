class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int temp = nums[i] ;
            currSum = Math.max(temp,temp+currSum);
            maxSum = Math.max(maxSum,currSum);
        }
        
        return maxSum ;
        
    }
}