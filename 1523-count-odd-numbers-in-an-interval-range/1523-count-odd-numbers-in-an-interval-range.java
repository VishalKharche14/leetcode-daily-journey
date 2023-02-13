class Solution {
    public int countOdds(int low, int high) {
        if(low == high) return (low & 1) == 1 ? 1 : 0 ;
        int ans = (high-low+1)>>1 ;
        return (low & 1) == 1 && (high & 1) == 1 ? ans+1 : ans ;
    }
    /*
    l - h = le= od=ans
    1 - 2 = 2 = 1 = 1
    1 - 3 = 3 = 1+1 = 2
    1 - 4 = 4 = 2 = 2
    1 - 5 = 5 = 2+1 = 3
    2 - 3 = 2 = 1 = 1
    2 - 4 = 3 = 1 = 1
    2 - 5 = 4 = 2 = 2
    2 - 6 = 5 = 2 = 2
    */  
}