class Solution {
    private int[] ans ;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graphs = new ArrayList<>(n) ;
        for(int i=0; i<n; i++){
            graphs.add(new ArrayList<>()) ;
        }
        for(int[] edge : edges){
            graphs.get(edge[0]).add(edge[1]) ;
            graphs.get(edge[1]).add(edge[0]) ;
        }
        ans = new int[n] ;
        dfs(0,-1,graphs,labels) ;
        return ans ;
    }
    private int[] dfs(int child, int parent, List<List<Integer>> graphs, String labels){
        
        int[] countArr = new int[26] ;
        
        for(int node : graphs.get(child)){
            if(node != parent){
                int[] temp = dfs(node,child,graphs,labels) ;
                for(int i=0; i<26; i++){
                    countArr[i] += temp[i] ;
                }
            }
        }
        
        countArr[labels.charAt(child)-'a']++ ;
        ans[child] = countArr[labels.charAt(child)-'a'] ;
        return countArr ;
    }
}