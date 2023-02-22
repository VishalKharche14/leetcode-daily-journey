class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = Arrays.stream(weights).max().getAsInt() , e = Arrays.stream(weights).sum();
        int minCap = 0;
        while(s<=e){
            int mid = s + ((e-s)>>1) ;
            if(canWeShip(weights,mid,days)){
                minCap = mid ;
                e = mid - 1 ;
            }
            else s = mid + 1 ;
        }
        return minCap ;
    }

    private boolean canWeShip(int[] weights, int mid, int days) {
        int curr = 0;
        for(int weight : weights){
            // if(weight > mid) return false ;
            curr += weight;
            if(curr > mid){
                curr = weight;
                days-- ;
                if(days < 1) return false ;
            }
        }
        return true ;
    }
}