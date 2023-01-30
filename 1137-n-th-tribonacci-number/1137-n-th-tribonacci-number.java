class Solution {
    public int tribonacci(int n) {
        if(n==0) return n;
        if(n<=2) return 1;
        
        int zero = 0;
        int one = 1;
        int two = 1;
        
        while(n-- > 2){
            int temp = zero + one + two ;
            zero = one ;
            one = two ;
            two = temp ;
        }
        
        return two ;
    }
}