class Solution {
    /*
    *   For a normal array -> Kadane's Algorithm can be used.
    *   but as it is circular array -> we have to modified the algo.
    *   if we find out the MINSUM and subtracted it from TOTAL_SUM then it can be solved.
    *   to get a MINSUM -> we will modify Kadanes algo by sign only.
    */
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