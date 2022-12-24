class Solution {
    /*
dp[i] = dp[i-1] + dp[i-2] + 2*(dp[i-3]+......dp[0]) 
dp[i] = dp[i-1] + dp[i-2] +  dp[i-3] + dp[i-3] + 2*(dp[i-4]+......dp[0]) 
dp[i] = dp[i-1] + dp[i-3] + {dp[i-2] + dp[i-3] + 2*(d[i-4] + ...... dp[0])}
dp[i] = dp[i-1] + dp[i-3] + dp[i-1] 
dp[i] = 2*dp[i-1] + dp[i-3] 
*/
    public int numTilings(int n) {
        int mod = (int)(1e9+7);
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n>=2) dp[2] = 2;
        
        for(int i=3; i<=n ; i++){
            dp[i] = 2*dp[i-1] + dp[i-3] ;
            dp[i] %= mod ;
        }
        
        return (int)dp[n] ;
    }
}