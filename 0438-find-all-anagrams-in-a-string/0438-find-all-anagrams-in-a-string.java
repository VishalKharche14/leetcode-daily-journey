class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Set<Character> set = p.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        int num = bitShift(p);
        
        for(int i=0; i+p.length()<=s.length(); i++){
            if(set.contains(s.charAt(i))){
                if(num == bitShift(s.substring(i,i+p.length()))) list.add(i);
            }
        }
        return list;
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











