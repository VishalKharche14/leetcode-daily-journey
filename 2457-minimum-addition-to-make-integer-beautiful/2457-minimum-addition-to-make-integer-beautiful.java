class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long num = n ;
        double p = 10 ;
        while(digitSum(num) > target){
            num = (long)(Math.ceil(num/p)*p) ;
            p*=10 ;
        }
        return num - n ;
    }
    private long digitSum(long n){
        long sum = 0;
        while(n > 0){
            sum += n%10 ;
            n /= 10 ;
        }
        return sum ;
    }
}
