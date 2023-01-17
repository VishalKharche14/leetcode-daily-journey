class Solution {
    int[][] dp ;
    public int minFlipsMonoIncr(String s) {
        dp = new int[s.length()][2] ;
        for(int[] arr : dp) Arrays.fill(arr,-1) ;
        
        return f(0,s.charAt(0),s);
    }
    private int f(int idx, char prev, String s){
        if(idx == s.length()) return 0 ;
        
        if(dp[idx][prev=='0'?0:1] != -1) return dp[idx][prev=='0'?0:1] ;
        char curr = s.charAt(idx) ;
        
        int noFlip = curr == '0' && prev == '1' ? 10000000 : f(idx+1,curr,s) ;
        
        int flip = curr == '1' && prev == '1' && idx != 0 ? 10000000 : 1 + f(idx+1,curr=='0' ? '1' : '0',s) ;
        
        return dp[idx][prev=='0'?0:1] = Math.min(noFlip,flip) ;
    }
}
/*
prev    curr    can_We_Flip
0       0           YES
0       1           YES
1       0           YES
1       1           NO
*/