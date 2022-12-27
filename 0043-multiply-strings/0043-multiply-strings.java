class Solution {
    public String multiply(String num1, String num2) {
        //if any of the nummber is Zero
        if(num1.charAt(0) =='0' || num2.charAt(0) =='0') return "0" ;
        // num1 should always be greater than num2
        if(num1.length() <= num2.length() ||  num1.compareTo(num2) < 0){
            String temp = new String(num1) ;
            num1 = num2 ;
            num2 = temp ;
        }
        //getting mutiplication table of num1
        String[] mult = new String[10] ;
        getMultiplicationTable(mult, num1) ;
        
        int n = num2.length()-1 ;
        String carry = "0" ;
        StringBuilder sb = new StringBuilder() ;
        
        while(n >= 0){
            String num = mult[Integer.parseInt(""+num2.charAt(n))] ;
            num = add(num,carry) ;
            if(num.length()>1) carry = num.substring(0,num.length()-1) ;
            else carry = "0" ;
            sb.append(num.charAt(num.length()-1)) ;
            n-- ;
        }
        while(carry.length()>0 && carry.charAt(0) != '0'){
            sb.append(carry.charAt(carry.length()-1)) ;
            carry = carry.substring(0,carry.length()-1);
        }
        
        return sb.reverse().toString() ;
    }
    private void getMultiplicationTable(String[] arr, String num){
        arr[0] = "0" ;
        arr[1] = num ;
        
        for(int i=2; i<10; i++){
            arr[i] = multiply(num,i) ;
        }
    }
    private String multiply(String num, int k){
        StringBuilder sb = new StringBuilder();
        int carry = 0 ;
        int n = num.length() ;
        for(int i=n-1; i>=0; i--){
            int digit1 = Integer.parseInt(""+num.charAt(i)) ;
            int mult = digit1 * k + carry ;
            carry = mult/10 ;
            sb.append(mult % 10) ;
        }
        while(carry > 0){
            sb.append(carry%10) ;
            carry /= 10 ;
        }
        
        return sb.reverse().toString() ;
    }
    private String add(String num1, String num2){
        
        if(num1.equals("0")) return num2 ;
        if(num2.equals("0")) return num1 ;
        
        int m = num1.length() ;
        int n = num2.length() ;
        int carry = 0;
        int i=m-1 , j=n-1 ;
        StringBuilder sb = new StringBuilder() ;
        
        while(i>=0 && j>=0){
            int digit1 = Integer.parseInt(""+num1.charAt(i)) ;
            int digit2 = Integer.parseInt(""+num2.charAt(j)) ;
            int sum = digit1+digit2+carry ;
            carry = sum/10 ;
            sb.append(sum%10) ;
            i--;
            j--;
        }
        
        if(j<0) sb.append(new StringBuilder(add(num1.substring(0,i+1),""+carry)).reverse());
        else sb.append(new StringBuilder(add(num2.substring(0,j+1),""+carry)).reverse());
        return sb.reverse().toString() ;
    }
}