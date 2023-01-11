class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graphs = new ArrayList<>() ;
        for(int i=0; i<n; i++){
            graphs.add(new ArrayList<>()) ;
        }
        for(int[] edge : edges){
            graphs.get(edge[0]).add(edge[1]) ;
            graphs.get(edge[1]).add(edge[0]) ;
        }
        int ans = dfs(0,-1,graphs,hasApple) ;
        // return hasApple.get(0) ? ans-2 : ans ;
        return ans-2 < 0 ? 0 : ans-2 ;
    }
    private int dfs(int child, int parent, List<List<Integer>> graphs, List<Boolean> hasApple){
        
        // if(graphs.get(child).size() == 1){
        //     return hasApple.get(child) ? 2 : 0 ;
        // }
        
        int pathCount = 0 ;

        for(int node : graphs.get(child)){
            if(node != parent){
                pathCount += dfs(node, child, graphs, hasApple) ;
            }
        }
        
        return pathCount != 0 || hasApple.get(child) ? pathCount+2 : pathCount ;
    }
}