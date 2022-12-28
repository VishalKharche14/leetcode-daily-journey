class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = Arrays.stream(piles).sum() ;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ;
        for(int pile : piles) maxHeap.add(pile) ;

        while(k>0){
            int initialStones = maxHeap.remove() ;
            int removedStones = Math.floorDiv(initialStones,2) ;
            maxHeap.add(initialStones - removedStones) ;
            sum -= removedStones ;
            k--;
        }

        return sum ;
    }
}