class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // create adjecancy list
        List<List<Integer>> graph = new ArrayList<>() ;
        for(int i=0; i<n; i++){
            graph.add(new ArrayList()) ;
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }
        
        int[] countOfNodes = new int[n] ;
        int[] distance = new int[n] ;
        
        preProcessTree(0,-1,graph,countOfNodes,distance) ;
        solve(0,-1,graph,countOfNodes,distance) ;
        
        return distance ;
    }
    
    private void preProcessTree(int currNode, int parent, List<List<Integer>> graph, int[] countOfNodes, int[] distance){
        for(int node : graph.get(currNode)){
            if(node == parent) continue ;
            preProcessTree(node,currNode,graph,countOfNodes,distance) ;
            countOfNodes[currNode] += countOfNodes[node] ;
            distance[currNode] += (distance[node] + countOfNodes[node]) ;
        }
        countOfNodes[currNode]++ ;
    }
    private void solve(int currNode, int parent, List<List<Integer>> graph, int[] countOfNodes, int[] distance){
        for(int node : graph.get(currNode)){
            if(node == parent) continue ;
            distance[node] = distance[currNode] - countOfNodes[node] + countOfNodes.length - countOfNodes[node] ;
            solve(node,currNode,graph,countOfNodes,distance) ;
        }
    }
}