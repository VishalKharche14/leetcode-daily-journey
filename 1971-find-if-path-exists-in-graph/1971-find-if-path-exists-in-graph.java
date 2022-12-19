class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // creating adjacancy list
        List<List<Integer>> graph = new ArrayList<>() ;
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }
        
        Set<Integer> visited = new HashSet<>() ;
        dfs(source,destination,graph,visited) ;
        
        return visited.contains(destination) ;
    }
    
    private void dfs (int s, int d, List<List<Integer>> graph, Set<Integer> visited){
        
        if(visited.contains(d)) return ;
        
        if(visited.contains(s)) return ;
        visited.add(s) ;
        
        for(int neighbours : graph.get(s)){
            dfs(neighbours,d,graph,visited) ;
        }
    }
}