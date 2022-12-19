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
        // dfs(source,destination,graph,visited) ;
        // return visited.contains(destination) ;
        
        return bfs(source,destination,graph,visited) ;
        
    }
    
    private void dfs (int s, int d, List<List<Integer>> graph, Set<Integer> visited){
        
        if(visited.contains(d)) return ;
        
        if(visited.contains(s)) return ;
        visited.add(s) ;
        
        for(int neighbours : graph.get(s)){
            dfs(neighbours,d,graph,visited) ;
        }
    }
    
    private boolean bfs(int source, int destination, List<List<Integer>> graph, Set<Integer> visited){
        Queue<Integer> q = new LinkedList<>() ;
        q.add(source) ;
        
        while(!q.isEmpty()){
            int node = q.remove() ;
            if(visited.contains(node)) continue ;
            visited.add(node) ;
            
            if(destination == node) return true ;
            
            for(int neighbours : graph.get(node)){
                q.add(neighbours) ;
            }
        }
        
        return false ;
    }
}