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
        
        int[] ans = new int [n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0] = 0 ;
        
        int[][] visited = new int[n][2];
        for(int[] arr : visited) Arrays.fill(arr,-1);
        
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
            
            if(visited[currNode][colour] != -1) continue;
            visited[currNode][colour] = count;
            // if(ans[currNode] != Integer.MAX_VALUE && count > ans[currNode]) continue;
            ans[currNode] = Math.min(ans[currNode],count);
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
        for(int i=0; i<n; i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}