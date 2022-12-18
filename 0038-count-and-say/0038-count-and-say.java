class Solution {
    public String countAndSay(int n) {
        String ans = "1" ;
        for(int i=2; i<=n; i++){
            ans = say(ans) ;
        }
        return ans ;
    }
    private String say(String s){
        StringBuilder sb = new StringBuilder() ;
        int i=0;
        int n = s.length() ;
        while(i<n){
            char ch = s.charAt(i) ;
            int count = 0;
            while(i<n && ch == s.charAt(i)){
                count++;
                i++;
            }
            sb.append(""+count) ;
            sb.append(ch) ;
        }
        return sb.toString() ;
    }
}