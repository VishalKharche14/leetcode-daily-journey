class Solution {
    public int findJudge(int n, int[][] trusts) {
        // return in_out_degree(n,trusts);
        return maxDegree(n,trusts);
    }
    private int in_out_degree(int n, int[][] trusts){
        if (trusts.length < n - 1) {
            return -1;
        }

        int[] indegrees = new int[n + 1];
        int[] outdegrees = new int[n + 1];

        for (int[] trust : trusts) {
            outdegrees[trust[0]]++;
            indegrees[trust[1]]++; 
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;    
    }
    private int maxDegree(int n, int[][] trusts){
        
        if(trusts.length < n-1) return -1 ;
        
        int[] degree = new int[n+1] ;
        for(int[] trust : trusts){
            degree[trust[0]]--;
            degree[trust[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(degree[i]==n-1) return i ;
        }
        return -1 ;
    }
}