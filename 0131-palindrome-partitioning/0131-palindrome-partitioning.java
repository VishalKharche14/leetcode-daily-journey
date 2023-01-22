class Solution {
    boolean [][] dp ;
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()] ;
        list = new ArrayList<>();
        dynamicP(0,s,new ArrayList<String>());
        // backtrack(0,s,new ArrayList<String>());
        return list ;
    }
    private void dynamicP(int idx, String s, List<String> curr){
        
        if(idx == s.length()){
            list.add(new ArrayList(curr));
            return ;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(s.charAt(idx) == s.charAt(i) && ( i-idx <= 2 || dp[idx+1][i-1])){
                dp[idx][i] = true ;
                curr.add(s.substring(idx,i+1));
                dynamicP(i+1,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private void backtrack(int idx, String s, List<String> curr){
        
        if(idx == s.length()){
            list.add(new ArrayList(curr));
            return ;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                backtrack(i+1,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}