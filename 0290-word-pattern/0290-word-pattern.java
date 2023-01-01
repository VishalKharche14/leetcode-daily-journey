class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split(" ") ;
        if(pattern.length() != arr.length) return false ;
        
        Map<Character,String> map = new HashMap<>() ;
        Map<String,Character> revMap = new HashMap<>() ;
        
        for(int i=0; i<pattern.length(); i++){
            
            char ch = pattern.charAt(i) ;
            
            if(map.containsKey(ch)){
                if(!arr[i].equals(map.get(ch))) return false ;
            }
            else{
                map.put(ch,arr[i]) ;
            }
            
            if(revMap.containsKey(arr[i])){
                if(ch != (revMap.get(arr[i]))) return false ;
            }
            else{
                revMap.put(arr[i],ch) ;
            }
        }
        
        return true ;
    }
}