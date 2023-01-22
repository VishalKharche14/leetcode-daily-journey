class Solution {
    List<List<String>> list;
    public List<List<String>> partition(String s) {
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
            if(isPalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                f(i+1,s,curr);
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