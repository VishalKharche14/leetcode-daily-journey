class Solution {
    int ans = 1;
    int[] dist = new int[100001] ;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> graphs = new ArrayList<>() ;
        for(int i=0; i<parent.length; i++){
            graphs.add(new ArrayList<>()) ;
        }
        for(int i=1; i<parent.length; i++){
            graphs.get(parent[i]).add(i) ;
        }
        dfs(0,graphs,s) ;
        return ans ;
    }
    private void dfs(int node, List<List<Integer>> graphs, String s){
        
        dist[node] = 1 ;
        
        for(int child : graphs.get(node)){
            dfs(child,graphs,s) ;
            
            if(s.charAt(node) != s.charAt(child)){
                ans = Math.max(ans,dist[node]+dist[child]) ;
                dist[node] = Math.max(dist[node], dist[child] + 1) ;
            }
        }
        
    }
}