class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        int low = 0;
        int high = nums.length-1;
        int ans = 0;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}