class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0 ;
        for(int i=0; i<nums.length; i++){
            int currReach = i+nums[i] ;
            maxReach = Math.max(maxReach,currReach) ;
            if(maxReach >= nums.length-1) return true ;
            if(maxReach <= i) return false ;
        }
        return true ;
    }
}