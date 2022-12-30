class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>() ;
        List<Integer> currPath = new ArrayList<>() ;
        dfs(0,graph,currPath,paths) ;
        return paths ;
    }
    private void dfs(int node, int[][] graph, List<Integer> currPath, List<List<Integer>> paths){
        currPath.add(node) ;
        if(node == graph.length-1){
            paths.add(new ArrayList(currPath)) ;
            currPath.remove(currPath.size()-1) ;
            return ;
        }
        for(int edge : graph[node]){
            dfs(edge,graph,currPath,paths) ;
        }
        
        currPath.remove(currPath.size()-1) ;
    }
}