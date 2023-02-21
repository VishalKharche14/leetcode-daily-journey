class Solution {
    public int singleNonDuplicate(int[] nums) {
        // if(nums.length == 1) return nums[0] ;
        int s = 0, e = nums.length-1;
        while(s <= e){
            int mid = (s+e)>>1 ;
            if(mid == 0 || mid == nums.length-1 || s==e || (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])) return nums[mid] ;
            if(nums[mid] == nums[mid+1]){
                if((mid&1)==1) e = mid-1 ;
                else s = mid+1 ;
            }
            else{
                if((mid&1)==1) s = mid+1; 
                else e = mid-1;
            }
        }
        return -1;
    }
}