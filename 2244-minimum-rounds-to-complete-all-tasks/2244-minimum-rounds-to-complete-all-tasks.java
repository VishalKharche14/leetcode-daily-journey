class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> freq = new HashMap<>() ;
        for(int task : tasks) freq.put(task,freq.getOrDefault(task,0)+1) ;
        int ans = 0 ;
        
        for(int val : freq.values()){
            if(val == 1) return -1 ;
            
            ans += (val/3) ;
            
            if (val%3 != 0){
                ans++ ;
            }
        }
        
        return ans ;
    }
}