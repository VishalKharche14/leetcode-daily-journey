class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length ;
        for(int i = 0; i < n; i++){
            capacity[i] -= rocks[i] ;
        }
        
        Arrays.sort(capacity) ;
        int i=0 , count=0 ;
        
        while(capacity[i] == 0){
            i++ ;
            count++;
        }
        while(i < n && additionalRocks >= capacity[i]){
            additionalRocks -= capacity[i] ;
            i++;
            if(additionalRocks >= 0) count++ ;
        }
        
        return count ;
    }
}