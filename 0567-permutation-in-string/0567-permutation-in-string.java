class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Set<Character> set = s1.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        int num = bitShift(s1);
        
        for(int i=0; i+s1.length()<=s2.length(); i++){
            if(set.contains(s2.charAt(i))){
                if(num == bitShift(s2.substring(i,i+s1.length()))) return true;
            }
        }
        return false;
    }

    private int bitShift(String s1) {
        int num = 0;
        for(char ch : s1.toCharArray()){
            int idx = ch - 'a' ;
            num += (1<<idx);
        }
        return num;
    }
}