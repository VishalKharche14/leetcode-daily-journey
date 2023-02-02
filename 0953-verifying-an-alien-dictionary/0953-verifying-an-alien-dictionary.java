class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> dictOrder = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            dictOrder.put(order.charAt(i),i);
        }
        String[] arr = words.clone();
        Arrays.sort(arr,(a,b)->{
            for(int i=0,j=0 ; i<a.length() && j<b.length(); i++,j++){
                if(dictOrder.get(a.charAt(i)) < dictOrder.get(b.charAt(j))){
                    return -1 ;
                }
                else if(dictOrder.get(a.charAt(i)) > dictOrder.get(b.charAt(j))){
                    return 1 ;
                }
            }
            return a.length()-b.length();
        });
        return Arrays.equals(words,arr);
    }
}