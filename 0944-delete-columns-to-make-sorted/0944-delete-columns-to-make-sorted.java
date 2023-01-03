class Solution {
    public int minDeletionSize(String[] strs) {
        StringBuilder sb = new StringBuilder() ;
        int ans = 0 ;
        
        for(int i=0; i<strs[0].length(); i++){
            for(int j=0; j<strs.length; j++){
                sb.append(strs[j].charAt(i)) ;
            }
            char[] arr = sb.toString().toCharArray() ;
            Arrays.sort(arr);
            if(!sb.toString().equals(new String(arr))) ans++ ;
            sb = new StringBuilder() ;
        }
        return ans ; 
    }
}