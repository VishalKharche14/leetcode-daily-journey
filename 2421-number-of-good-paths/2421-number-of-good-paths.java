class Solution {
    int[] parents ;
    int[] heights ;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        //for DSU
        parents = new int[vals.length] ;
        heights = new int[vals.length] ;
        Arrays.fill(heights,1) ;
        for(int i=0; i<vals.length; i++){
            parents[i] = i ;
        }
        //Adjecancy List
        List<List<Integer>> graphs = new ArrayList<>() ;
        for(int i=0; i<vals.length; i++) graphs.add(new ArrayList<>()) ;
        for(int[]edge : edges){
            graphs.get(edge[0]).add(edge[1]) ;
            graphs.get(edge[1]).add(edge[0]) ;
        }
        // map of value -> nodes having the value
        // TreeMap to store keys in ascending order
        Map<Integer,List<Integer>> map = new TreeMap<>() ;
        for(int i=0; i<vals.length; i++){
            if(!map.containsKey(vals[i])){
                map.put(vals[i],new ArrayList()) ;
            }
            map.get(vals[i]).add(i) ;
        }
        // isActive array to make union and find common parents between subtrees
        boolean[] isActive = new boolean[vals.length] ;
        
        int result = vals.length ;
        
        for(int key : map.keySet()){
            // TreeMap will insure -> starting from smallest key first
            // extracting list of nodes having the same node value
            List<Integer> sameValueNodes = map.get(key) ;
            
            // marking the nodes as active and avaialble to unite
            for(int node : sameValueNodes){
                isActive[node] = true ;
                // iterating over the childs of active nodes
                for(int child : graphs.get(node)){
                    //making union only if child is active
                    if(isActive[child]) makeUnion(node, child) ;
                }
            }
            //parents = god -> adding parents of nodes to find connected components
            List<Integer> god = new ArrayList<>() ;
            for(int node : sameValueNodes){
                god.add(findParent(node)) ;
            }            
            Collections.sort(god) ;
            
            for(int i=0; i<god.size(); i++){
                int currParent = god.get(i) ;
                int count = 0 ;
                while(i<god.size() && god.get(i)==currParent){
                    count++ ;
                    i++ ;
                }
                i-- ;
                
                result += ((count*(count-1))/2) ;
            }
        }
        
        return result ;
    }
    private int findParent(int p){
        if(parents[p] == p) return p ;
        return parents[p] = findParent(parents[p]) ;
    }
    private void makeUnion(int p, int q){
        int x = findParent(p) ;
        int y = findParent(q) ;
        
        if(x == y) return ;
        if (heights[x] > heights[y]){
            int temp = x ;
            x = y ;
            y = temp ;
        }
        
        heights[y] += heights[x];
        parents[x] = y;
        // if(heights[x] > heights[y]){
        //     parents[y] = x ;
        // }
        // else if(heights[y] > heights[x]){
        //     parents[x] = y ;
        // }
        // else{
        //     parents[y] = x ;
        //     heights[y]++ ;
        // }
        
    }
}