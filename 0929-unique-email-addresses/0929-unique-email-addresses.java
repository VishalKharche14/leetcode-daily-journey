class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        
        for(String email : emails){
            set.add(decode(new StringBuilder(email)));
        }
        
        return set.size();
    }
    
    private String decode(StringBuilder email){
        int idx = 0;
        
        while(email.charAt(idx) != '@'){
            if(email.charAt(idx) == '.'){
                email.deleteCharAt(idx);
                continue ;
            }
            else if(email.charAt(idx) == '+'){
                while(email.charAt(idx) != '@'){
                    email.deleteCharAt(idx);
                }
                break ;
            }
            idx++;
        }
        
        return email.toString() ;
    }
}