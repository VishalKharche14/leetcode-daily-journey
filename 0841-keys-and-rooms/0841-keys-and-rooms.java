class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int count = 0 ;
        Set<Integer> visited = new HashSet<>() ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(0) ;
        
        while(!q.isEmpty()){
            int room = q.remove() ;
            if(visited.contains(room)) continue ;
            visited.add(room) ;
            count++;
            
            for(int key : rooms.get(room)){
                q.add(key) ;
            }
        }
        
        return count == rooms.size() ;
        
    }
}