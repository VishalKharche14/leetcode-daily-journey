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