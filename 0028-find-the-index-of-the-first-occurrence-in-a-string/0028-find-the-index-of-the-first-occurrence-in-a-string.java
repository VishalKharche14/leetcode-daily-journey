class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for(int i=0; i+len <= haystack.length(); i++){
            if(isEqual(needle,haystack.substring(i,i+len))) return i ;
        }
        return -1;
    }
    private boolean isEqual(String pattern, String check){
        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i) != check.charAt(i)) return false; 
        }
        return true ;
    }
}