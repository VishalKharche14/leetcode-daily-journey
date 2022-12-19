class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length ; 
        int n = matrix[0].length ;
        
        int[][] dp = new int[m][n] ;
        for(int[] arr : dp) Arrays.fill(arr, -1) ;
        int ans = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans,f(i,j,m,n,matrix,dp));
            }
        }
        
        return ans ;
    }
    private int f(int r, int c, int m, int n, int[][] matrix, int[][] dp){
        
        if(dp[r][c] != -1) return dp[r][c] ;
        
        int ans = 1 ;
        int[][] moves = {{0,-1},{0,1},{-1,0},{1,0}} ;
        for(int i=0; i<4; i++){
            int x = r + moves[i][0] ;
            int y = c + moves[i][1] ;
            
            if(x>=0 && y>=0 && x<m && y<n && matrix[x][y] > matrix[r][c]){
                ans = Math.max(ans, 1 + f(x,y,m,n,matrix,dp)) ;
            }
        }
        
        return dp[r][c] = ans ;
    }
}