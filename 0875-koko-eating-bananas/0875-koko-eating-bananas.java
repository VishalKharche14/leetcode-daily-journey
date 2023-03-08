class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1 , e = Arrays.stream(piles).max().getAsInt();
        int ans = 0 ;
        while(s <= e){
            int mid = s + ((e-s)>>1);
            if(isPossible(mid,piles,h)){
                ans = mid ;
                e = mid - 1 ;
            }
            else s = mid + 1 ;
        }
        return ans ;
    }
    private boolean isPossible(int perHourRate, int[] piles, int hours){
        long time = 0;
        for(int bananas : piles){
            time += (bananas / perHourRate) ;
            if(bananas % perHourRate != 0) time++ ;
        }
        return time <= 1l*hours ;
    }
}