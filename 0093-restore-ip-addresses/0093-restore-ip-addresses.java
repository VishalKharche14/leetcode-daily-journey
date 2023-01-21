class Solution {
    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        if(s.length() > 12) return list;
        f(0,0,s,new StringBuilder());
        return list ;
    }
    private void f(int idx, int count, String s, StringBuilder sb){
        
        if(count == 4){
            if(idx >= s.length()){
                list.add(sb.substring(0,sb.length()-1).toString());
            }
            return;
        }
        if(idx >= s.length()) return ;
        
        
        //considering number of length == 1
        sb.append(s.charAt(idx));
        sb.append('.');
        f(idx+1,count+1,s,sb);
        sb.delete(sb.length()-2,sb.length());
        //considering number of length == 2
        if(idx+2 <= s.length() && Integer.parseInt(s.substring(idx,idx+2)) > 9){
            sb.append(s.substring(idx,idx+2));
            sb.append('.');
            f(idx+2,count+1,s,sb);
            sb.delete(sb.length()-3,sb.length());
        }
        //considering number of length == 3
        if(idx+3 <= s.length() && Integer.parseInt(s.substring(idx,idx+3)) > 99
          && Integer.parseInt(s.substring(idx,idx+3)) <= 255){
            sb.append(s.substring(idx,idx+3));
            sb.append('.');
            f(idx+3,count+1,s,sb);
            sb.delete(sb.length()-4,sb.length());
        }
    }
}