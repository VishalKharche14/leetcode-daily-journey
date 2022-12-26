class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length ;
        int maxReach = 0 ;
        for(int i=0; i<len; i++){
            int currReach = i+nums[i] ;
            maxReach = Math.max(maxReach,currReach) ;
            if(maxReach >= len-1) return true ;
            if(maxReach <= i) return false ;
        }
        return true ;
    }
}