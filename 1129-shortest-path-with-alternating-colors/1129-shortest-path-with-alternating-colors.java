class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer,List<Integer>> redList = new HashMap<>();
        for(int[] edge : redEdges){
            redList.putIfAbsent(edge[0],new ArrayList<>());
            redList.get(edge[0]).add(edge[1]);
        }
        Map<Integer,List<Integer>> blueList = new HashMap<>();
        for(int[] edge : blueEdges){
            blueList.putIfAbsent(edge[0],new ArrayList<>());
            blueList.get(edge[0]).add(edge[1]);
        }
        
        int[][] visited = new int[n][2];
        for(int[] arr : visited) Arrays.fill(arr,Integer.MAX_VALUE);
        
        int count = 1 ;
        //red = 0 blue = 1
        Queue<int[]> q = new LinkedList<>();
        if(blueList.containsKey(0)) for(int node : blueList.get(0)) q.add(new int[]{node, 1});
        if(redList.containsKey(0)) for(int node : redList.get(0)) q.add(new int[]{node,0});
        q.add(null);
        
        while(!q.isEmpty()){
            int[] temp = q.remove();
            if(temp==null){
                if(!q.isEmpty()) q.add(null);
                count++;
                continue;
            }
            int currNode = temp[0];
            int colour = temp[1];
            
            if(visited[currNode][colour] != Integer.MAX_VALUE) continue;
            visited[currNode][colour] = count;
            
            if(colour==0){
                if(blueList.containsKey(currNode)) for(int node : blueList.get(currNode)){
                    q.add(new int[]{node,1});
                }
            }else {
                if(redList.containsKey(currNode)) for(int node : redList.get(currNode)){
                    q.add(new int[]{node,0});
                }
            }
        }
        
        int[] ans = new int [n];
        for(int i=1; i<n; i++){
            ans[i] = Math.min(visited[i][0],visited[i][1]);
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1 ;
        }
        return ans;
    }
}