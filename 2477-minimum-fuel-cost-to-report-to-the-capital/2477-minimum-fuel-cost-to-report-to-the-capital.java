class Solution {
    long cost = 0;
    public long dfs(int node, List<Integer>[] list, boolean[] visited, int seats){
        visited[node] = true;
        
        long peoples = 1;
        for(int i=0; i<list[node].size(); i++){
            if(!visited[list[node].get(i)]) peoples += dfs(list[node].get(i),list,visited,seats);
        }
        
        long cars = peoples/seats;
        if(peoples%seats !=0) cars++; 
        
        if(node!=0) cost+=cars;
        
        return peoples;
        
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] list = createAdjecancyList(roads);
        boolean [] visited = new boolean[roads.length+1];
        
        for(int i=0; i<list.length; i++){
            if(!visited[i]) dfs(i,list,visited,seats);
        }
        return cost;
    }
    public List<Integer>[] createAdjecancyList(int[][] roads){
        int n = roads.length ;
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++) list[i] = new ArrayList();
        
        for(int i=0; i<n; i++){
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
        }
        return list;
    }
}