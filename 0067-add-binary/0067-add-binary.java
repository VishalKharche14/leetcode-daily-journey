class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0 ;
        int idx1 = a.length()-1 ;
        int idx2 = b.length()-1 ;

        while(idx1>=0 || idx2>=0 || carry >= 1){
            int num1 = idx1>=0 ? a.charAt(idx1--)-'0' : 0 ;
            int num2 = idx2>=0 ? b.charAt(idx2--)-'0' : 0 ;
            int sum = num1+num2+carry ;
            carry = sum>>1;
            ans.append(sum&1);
        }
        return ans.reverse().toString();
    }
}