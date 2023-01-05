class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[1] < b[1]) return -1 ;
            return 1 ;
        });
        
        int idx = 0 , arrows = 0 ;
        long maxSpan = Long.MIN_VALUE ;
        
        while(idx < points.length){
            if (maxSpan < points[idx][0]){
                arrows++ ;
                maxSpan = points[idx][1] ;
            }
            idx++;
        }
        
        return arrows ;
    }
}