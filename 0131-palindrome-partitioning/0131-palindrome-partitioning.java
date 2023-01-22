class Solution {
    boolean [][] dp ;
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()] ;
        list = new ArrayList<>();
        f(0,s,new ArrayList<String>());
        return list ;
    }
    private void f(int idx, String s, List<String> curr){
        
        if(idx == s.length()){
            list.add(new ArrayList(curr));
            return ;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(s.charAt(idx) == s.charAt(i) && ( i-idx <= 2 || dp[idx+1][i-1])){
                dp[idx][i] = true ;
                curr.add(s.substring(idx,i+1));
                f(i+1,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}