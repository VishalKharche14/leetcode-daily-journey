class Solution {
    public int numTilings(int n) {
        int mod = (int)(1e9+7);
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n>=2) dp[2] = 2;
        
        for(int i=3; i<=n ; i++){
            //Vertical domino
            dp[i] += dp[i-1];
            //Horizontal dominos
            dp[i] += dp[i-2];
            
            //Tromino
            long ans = 0;
            for(int j=3; i-j>=0; j++){
                ans += dp[i-j];
            }
            dp[i] += 2*ans ;
            dp[i] %= mod ;
        }
        
        return (int)dp[n] ;
    }
}