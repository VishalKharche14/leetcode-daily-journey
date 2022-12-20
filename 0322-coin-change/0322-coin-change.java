class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1] ;
        for(int[] arr : dp) Arrays.fill(arr,-1) ;
        int ans = f(coins.length-1,amount,coins,dp) ;
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
    private int f(int idx, int target, int[] coins, int[][] dp){
        if(target == 0) return 0 ;
        if (idx < 0 || target < 0) return Integer.MAX_VALUE ;
        
        if(dp[idx][target] != -1) return dp[idx][target] ;
        
        int notTake = f(idx-1,target,coins,dp) ;
        int take = f(idx,target-coins[idx],coins,dp) ;
        if(take != Integer.MAX_VALUE) take++;
        
        return dp[idx][target] = Math.min(take,notTake) ;
    }
}