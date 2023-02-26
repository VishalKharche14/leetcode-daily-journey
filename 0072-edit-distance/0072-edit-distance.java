class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length() ;
        int n = word2.length() ;
        int[][] dp = new int[m][n] ;
        for(int[] arr : dp) Arrays.fill(arr,-1) ;

        return f(0,0,word1,word2,dp);
    }
    private int f(int i, int j, String s, String target, int[][] dp){
        if(i>=s.length()) return target.length()-j ;
        if(j>=target.length()) return s.length()-i ;
        
        if(dp[i][j] != -1) return dp[i][j] ;

        if(s.charAt(i) == target.charAt(j)){
            return dp[i][j] = f(i+1,j+1,s,target,dp) ;
        }
        else{
            int insert = f(i,j+1,s,target,dp) ;
            int delete = f(i+1,j,s,target,dp) ;
            int replace = f(i+1,j+1,s,target,dp) ;

            return dp[i][j] = 1 + Math.min(Math.min(insert,delete),replace) ;
        }
    }
}