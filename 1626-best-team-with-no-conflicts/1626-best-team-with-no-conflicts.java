class Solution {
    int[][]dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] ageScore = new int[scores.length][2];
        for(int i=0; i<scores.length; i++){
            ageScore[i][0] = ages[i];
            ageScore[i][1] = scores[i];
        }
        Arrays.sort(ageScore,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        dp = new int[scores.length][scores.length+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return f(0,0,ageScore);
    }
    private int f(int idx, int prevIdx, int[][] ageScore){
        
        if(idx == ageScore.length) return 0;
        
        if(dp[idx][prevIdx] != -1) return dp[idx][prevIdx] ;
        int take = 0 ;
        int notTake = f(idx+1, prevIdx, ageScore);
        
        if(prevIdx == 0 || ageScore[prevIdx-1][1] <= ageScore[idx][1]){
            take = ageScore[idx][1] + f(idx+1, idx+1, ageScore);
        }
        
        return dp[idx][prevIdx] = Math.max(take,notTake);
    }
}