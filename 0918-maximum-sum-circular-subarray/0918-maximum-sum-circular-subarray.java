class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int arrSum = 0 , maxSum = Integer.MIN_VALUE , minSum = Integer.MAX_VALUE ;
        int tempMaxSum = 0 , tempMinSum = 0 ;
        
        for(int n : nums){
            arrSum += n ;
            tempMaxSum += n ;
            tempMinSum += n ;
            
            maxSum = Math.max(maxSum,tempMaxSum) ;
            if (tempMaxSum < 0) tempMaxSum = 0 ;
            minSum = Math.min(minSum,tempMinSum) ;
            if(tempMinSum > 0) tempMinSum = 0 ;
        }
        
        return arrSum == minSum ? maxSum : Math.max(maxSum , arrSum-minSum) ;
    }
}