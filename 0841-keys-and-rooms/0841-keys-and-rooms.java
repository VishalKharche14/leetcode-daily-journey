class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    
        return bfs(rooms) ;
        
//         Set<Integer> visited = new HashSet<>() ;
//         visited.add(0) ;
        
//         return dfs(0,visited,rooms) ;
    }
    private boolean dfs(int room, Set<Integer> visited, List<List<Integer>> keys){
        for(int key : keys.get(room)){
            if(!visited.contains(key)){
                visited.add(key) ;
                dfs(key,visited,keys) ;
            }
        }
        return keys.size() == visited.size() ;
    }
    private boolean bfs(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>() ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(0) ;
        
        while(!q.isEmpty()){
            int room = q.remove() ;
            if(visited.contains(room)) continue ;
            visited.add(room) ;
            
            for(int key : rooms.get(room)){
                q.add(key) ;
            }
        }
        
        return visited.size() == rooms.size() ;
        
    }
}