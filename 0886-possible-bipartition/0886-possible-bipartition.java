class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>() ;
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList()) ;
                
        }
        for(int[] nodes : dislikes){
            graph.get(nodes[0]).add(nodes[1]) ;
            graph.get(nodes[1]).add(nodes[0]) ;
        }
        
        int[] colour = new int[n+1] ;
        Arrays.fill(colour,-1) ; //not visited ;
        boolean ans = true ;
        
        for(int i=1; i<=n; i++){
            if(colour[i] == -1 && ans){
                colour[1] = 0 ; // visited and marked with colour red
                ans = ans && bfs(i,graph,colour) ;
            }
        }
        
        return ans ;
    }
    private boolean bfs(int tmpnode ,List<List<Integer>> graph ,int[] colour ){
        Queue<Integer> q = new LinkedList<>() ;
        q.add(tmpnode) ;
        
        while(!q.isEmpty()){
            int node = q.remove() ;
            int clr = colour[node] ;
            
            for(int neighbours : graph.get(node)){
                if(colour[neighbours] == -1){
                    colour[neighbours] = 1 - clr ; // colouring with opposite colour to the parent node
                    q.add(neighbours) ;
                }
                else if(colour[neighbours] == clr) return false ;
            }
        }
        
        return true ;
    }
}

/*
0    1 -> 2
1    2 -> 1
0    3 -> 4  5
1    4 -> 3  5
0    5 -> 4  3
*/