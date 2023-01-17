class Solution {
    /*
    dividing String into 2 parts -> left and right.
    left part should be All ZEROS and right part should be All ONES
    intially starting with left part as length 0 -> i.e. whole string in right part.
    counting all zeros in the string will be equal to flips required to make right part = All ONES.
    
    iterating from left means -> increasing left part and simultaneously reducing right part.
        while iterating, if we encounter a ZERO -> no need to flip as we need all Zeros in left           part. it means to make a right part of all ONES we need to flip (ans-1) zeros.
        
        Similarly if we encounter a ONE -> means we need to flip it as left part should be all             ZEROS.
    
    */
    public int minFlipsMonoIncr(String s) {
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
}