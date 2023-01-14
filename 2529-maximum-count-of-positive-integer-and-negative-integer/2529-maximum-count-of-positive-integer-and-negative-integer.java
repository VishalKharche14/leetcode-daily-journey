class Solution {
    public int maximumCount(int[] nums) {
        int indexOfZero = Arrays.binarySearch(nums,0) ;
        
        if(indexOfZero < 0){
            // Zero is not present
            // indexOfZero = -1-(index where zero should be inserted) ;
            indexOfZero++ ;
            indexOfZero *= -1 ;
            return Math.max(indexOfZero, nums.length-indexOfZero) ;
            
        }
        else{
            // we found a zero.
            // as there might be multiple zeros, we need to find index of first Zero and last Zero.
            while(indexOfZero >= 0 && nums[indexOfZero] == 0){
                indexOfZero-- ;
            }
            indexOfZero++ ;
            int negatives = indexOfZero ;
            
            while(indexOfZero < nums.length && nums[indexOfZero] == 0){
                indexOfZero++ ;
            }
            
            indexOfZero-- ;
            int positives = nums.length - indexOfZero-1 ;
            
            return Math.max(negatives, positives) ;
        }
    }
}