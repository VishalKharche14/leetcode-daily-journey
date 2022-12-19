class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder() ;
        int carry = 0;
        int m = num1.length()-1 , n = num2.length()-1 ;
        while(n>=0 && m>=0){
            int a = num1.charAt(m--) - '0' ;
            int b = num2.charAt(n--) - '0' ;
            int sum = a+b+carry ;
            sb.append(sum%10) ;
            carry = sum/10 ;
        }
        while(n>=0){
            int b = num2.charAt(n--) - '0' ;
            int sum = b+carry ;
            sb.append(sum%10) ;
            carry = sum/10 ;
        }
        while(m>=0){
            int a = num1.charAt(m--) - '0' ;
            int sum = a+carry ;
            sb.append(sum%10) ;
            carry = sum/10 ;
        }
        if(carry != 0) sb.append(carry) ;
        return sb.reverse().toString() ;
    }
}