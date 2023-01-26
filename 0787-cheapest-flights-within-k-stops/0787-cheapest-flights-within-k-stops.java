class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        List<List<int[]>> graphs = new ArrayList<>();
        for(int i=0; i<n; i++){
            graphs.add(new ArrayList<>());
        }
        for(int[] detail : flights){
            graphs.get(detail[0]).add(new int[]{detail[1],detail[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        q.add(null);
        int stops = 0 ;

        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);

        while(!q.isEmpty() && stops <= k){
            int[] temp = q.remove();
            if(temp==null){
                stops++;
                if(!q.isEmpty()) q.add(null);
                continue;
            }

            for(int[] arr : graphs.get(temp[0])){
                if(arr[1]+temp[1] < prices[arr[0]]){
                    prices[arr[0]] = arr[1]+temp[1] ;
                    q.add(new int[]{arr[0],arr[1]+temp[1]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}