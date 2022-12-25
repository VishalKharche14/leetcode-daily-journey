class Solution {
    /*
    1   1   3
    low = 0     high = 2    mid = 1
    */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price) ;
        int low = 0 , high = price[price.length-1] - price[0] ;
        int ans = 0 ;
        
        while(low <= high){
            int mid = (low + high )>>1 ;
            
            if(canBeAnswer(mid,price,k)){
                low = mid + 1 ;
                ans = mid ;
            }
            else high = mid - 1 ;
        }
        
        return ans ;
    }
    private boolean canBeAnswer(int diff, int[] price, int k){
        int curr = price[0] ;
        k-- ;
        while(k > 0){
            int idx = Arrays.binarySearch(price,curr+diff) ;
            if(idx < 0){
                idx++ ;
                idx*=-1 ;
            }
            if(idx < price.length) curr = price[idx] ;
            else return false ;
            k-- ;
        }
        
        return true ;
    }
}