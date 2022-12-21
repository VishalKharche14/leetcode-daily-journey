class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long currSum = getSum(n) ;
        long diff = currSum - target ;
        
        if(diff <= 0) return 0l ;
        
        StringBuilder sb = new StringBuilder() ;
        while(currSum > target){
            long lastDigit = n % 10 ;
            
            if(lastDigit != 0){
                sb.append(10-lastDigit);
                n /= 10 ;
                n++ ;
            }
            else {
                sb.append(0) ;
                n /= 10 ;
            }
            
            currSum = getSum(n) ;
        }
        return Long.parseLong(sb.reverse().toString()) ;
    }
    private long getSum(long n){
        long sum = 0;
        while(n > 0){
            sum += n%10 ;
            n /= 10 ;
        }
        return sum ;
    }
}
