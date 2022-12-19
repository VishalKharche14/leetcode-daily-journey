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
        
        // return bfs(source,destination,graph,visited) ;
        
        return dsu(n,edges,source,destination) ;
        
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
    
    private boolean dsu(int n, int[][] edges, int source, int destination){
        int[] parents = new int[n] ;
        int[] heights = new int[n] ;
        
        for(int i=0; i<n; i++){
            parents[i] = i ;
        }
        
        for(int[] edge : edges){
            union(edge[0],edge[1],parents,heights) ;
        }
        
        return findRoot(source,parents) == findRoot(destination,parents) ;
    }
    private void union(int x, int y, int[] parents, int[] heights){
        int r1 = findRoot(x,parents);
        int r2 = findRoot(y,parents);

        if(r1 == r2) return;

        if(heights[r1] == heights[r2]){
            parents[r2] = r1;
            heights[r1]++;
        }
        else if(heights[r1] < heights[r2]){
            parents[r1] = r2;
        }
        else parents[r2] = r1;
    }
    private int findRoot(int node, int[] parents){
        
        if(node == parents[node]) return node;
        parents[node] = findRoot(parents[node],parents);

        return parents[node];
    }
}