class Solution {
    
    public int minFlipsMonoIncr(String s) {
        // return dynamicWindow(s) ;
        return dp(s) ;
    }
    /*
    dividing String into 2 parts -> left and right.
    left part should be All ZEROS and right part should be All ONES
    intially starting with left part as length 0 -> i.e. whole string in right part.
    counting all zeros in the string will be equal to flips required to make right part = All ONES.
    
    iterating from left means -> increasing left part and simultaneously reducing right part.
        while iterating, if we encounter a ZERO -> no need to flip as we need all Zeros in left           part. it means to make a right part of all ONES we need to flip (ans-1) zeros.
        
        Similarly if we encounter a ONE -> means we need to flip it as left part should be all             ZEROS.
    
    */
    private int dynamicWindow(String s) {
        //counting all Zeros
        int zero = 0 ;
        for(char ch : s.toCharArray()){
            if (ch=='0') zero++ ;
        }
        //converting all Zeros to Ones might be one of the answer
        int ans = zero ;
        
        for(char ch : s.toCharArray()){
            if (ch=='0'){
                ans = Math.min(ans,--zero) ;
            }
            else zero++ ;
        }
        
        return ans ;
    }
    /*
    dp[i] = no. of flips required to make a subString from(0 to i) monotone increasing .
    dp[0] = 0 ; // single digit string will always be monotone increasing.
    if s.charAt(i) == '1' then dp[i] = dp[i-1] because we can append 1 to any string to make it monotone increasing.
    if s.charAt(i) =='0' -> it have 2 cases -> min of both will be the answer.
        1. flip it -> if we decided to slip it will become same condition as above because we can               append 1 to any string to make it monotone increasing just our flip count will be                 increased by 1 .
              so dp[i] = 1+dp[i-1] ;
              
        2. do not flip it. -> then we need to flip all the 1 present before i.
                dp[i] = number of 1's present in substring[0,i-1] (both inclusive) .
    */
    private int dp(String s){
        int one = 0 ;
        int ans = 0 ;
        
        for(char ch : s.toCharArray()){
            if(ch == '1') one++ ;
            else ans = Math.min(1+ans,one) ;
        }
        
        return ans ;
    }
}