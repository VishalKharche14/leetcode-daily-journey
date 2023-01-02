class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) || word.equals(word.toLowerCase()) || (word.substring(1).equals(word.substring(1).toLowerCase()) && (int)word.charAt(0)<=90) ;
    }
}