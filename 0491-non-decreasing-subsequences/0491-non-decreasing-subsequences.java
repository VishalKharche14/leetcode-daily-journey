class Solution {
    Set<List<Integer>> set ;
    public List<List<Integer>> findSubsequences(int[] nums) {
        set = new HashSet<>() ;
        f(0,-101,nums,new ArrayList<>()) ;
        return new ArrayList<>(set) ;
    }
    private void f(int idx, int prev, int[] nums, List<Integer> temp){
        
        if(idx == nums.length){
            if(temp.size()>1) set.add(new ArrayList<>(temp)) ;
            return ;
        }
        
        int curr = nums[idx] ;
        if(curr >= prev){
            temp.add(curr);
            f(idx+1,curr,nums,temp);
            temp.remove(temp.size()-1);
        }
        
        f(idx+1,prev,nums,temp) ;
        
    }
}