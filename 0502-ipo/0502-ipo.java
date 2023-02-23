class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> proCap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0; i<capital.length; i++){
            proCap.add(new int[]{profits[i],capital[i]});
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        while((!proCap.isEmpty() || !maxHeap.isEmpty()) && k>0){
            if(!proCap.isEmpty() && proCap.peek()[1]<=w){
                maxHeap.add(proCap.remove());
            }
            else{
                if(!maxHeap.isEmpty()){
                    w+=maxHeap.remove()[0];
                    k--;
                }
                else break;
            }
        }
        return w ;
    }
}

