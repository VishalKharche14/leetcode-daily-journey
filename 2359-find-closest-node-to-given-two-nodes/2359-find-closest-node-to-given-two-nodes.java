class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[]dist1 = new int[edges.length] ;
        int[]dist2 = new int[edges.length] ;
        Arrays.fill(dist1,edges.length+1) ;
        Arrays.fill(dist2,edges.length+1) ;
        dist1[node1] = 0 ;
        dist2[node2] = 0 ;
        int dist = 1 ;
        
        while(edges[node1] != -1){
            if(dist1[edges[node1]] != edges.length+1) break ;
            dist1[edges[node1]] = dist ;
            node1 = edges[node1] ;
            dist++ ;
        }
        
        dist = 1 ;
        while(edges[node2] != -1){
            if(dist2[edges[node2]] != edges.length+1) break ;
            dist2[edges[node2]] = dist ;
            node2 = edges[node2] ;
            dist++ ;
        }
        
        int max = Integer.MAX_VALUE ;   
        int ans = -1 ;
        for(int i=0; i<edges.length; i++){
            int temp = Math.max(dist1[i],dist2[i]);
            if(temp < max){
                max = temp ;
                ans = i ;
            }
        }
        
        return max == edges.length+1 ? - 1 : ans ;
    }
}