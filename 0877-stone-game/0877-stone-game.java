class Solution {
    public boolean stoneGame(int[] piles) {
        int evenSum = 0 ;
        int oddSum = 0 ;
        
        for(int i=0; i<piles.length; i+=2){
            evenSum += piles[i] ;
        }
        for(int i=1; i<piles.length; i+=2){
            oddSum += piles[i] ;
        }
        
        return evenSum != oddSum ;
    }
}