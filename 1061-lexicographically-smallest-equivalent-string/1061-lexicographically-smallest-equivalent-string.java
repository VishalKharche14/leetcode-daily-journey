class Solution {
    int[] parents;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parents = new int[26] ;
        for(int i=0; i<26; i++){
            parents[i] = i ;
        }
        
        for(int i=0; i<s1.length(); i++){
            makeUnion(s1.charAt(i)-'a' , s2.charAt(i)-'a') ;
        }
        
        StringBuilder sb = new StringBuilder() ;
        for(char ch : baseStr.toCharArray()){
            sb.append((char)(findParent(ch-'a')+'a')) ;
        }
        
        return sb.toString() ;
    }
    
    private void makeUnion(int p, int q){
        int x = findParent(p) ;
        int y = findParent(q) ;
        
        if(x != y){
            if(x < y){
                parents[y] = x ;
            }
            else parents[x] = y ;
        }
    }
    
    private int findParent(int p){
        if(p == parents[p]){
            return p ;
        }
        
        return parents[p] = findParent(parents[p]) ;
    }
}
