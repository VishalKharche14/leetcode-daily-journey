class Solution {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public int maxPoints(int[][] points) {
        
        int maxPoints = 0 ;
        for(int i=0; i<points.length-1; i++){
            HashMap<String,Integer> map = new HashMap<>() ;
            for(int j=i+1; j<points.length; j++){
                int x = points[j][0] - points[i][0] ;
                int y = points[j][1] - points[i][1] ;
                int hcf = gcd(x,y) ;
                String key = (x/hcf) + "!" + (y/hcf) ;
                map.put(key,map.getOrDefault(key,0)+1) ;
                maxPoints = Math.max(maxPoints,map.get(key)) ;
            }
        }
        
        return maxPoints+1 ;
    }
}