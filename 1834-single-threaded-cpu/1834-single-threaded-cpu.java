class Solution {
    public int[] getOrder(int[][] tasks) {
        // to Preserve initial index to get the sequence of tasks
        Map<int[],Integer> indices = new HashMap<>() ;
        for(int i=0; i<tasks.length; i++){
            indices.put(tasks[i],i) ;
        }
        // sorting on the basis of start time of the tasks
        Arrays.sort(tasks,(t1,t2)->{
            if(t1[0] == t2[0]) return t1[1] - t2[1] ;
            return t1[0] - t2[0] ;
        });

        int endTime = 0 ;
        List<Integer> sequence = new ArrayList<>() ;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]) return indices.get(a) - indices.get(b) ;
                return a[1] - b[1] ;
            }
        });

//         for(int i=0; i<tasks.length; i++){
//             while(endTime <= tasks[i][0] && !minHeap.isEmpty()) {
//                 int[] taskToPerform = minHeap.remove();
//                 sequence.add(indices.get(taskToPerform));
//                 endTime += taskToPerform[1];
//             }
//             minHeap.add(tasks[i]) ;
//         }

//         while(!minHeap.isEmpty()){
//             sequence.add(indices.get(minHeap.remove())) ;
//         }
        int idx = 0 ;
        while(idx < tasks.length || !minHeap.isEmpty()){
            if(minHeap.isEmpty() && endTime < tasks[idx][0]){
                endTime = tasks[idx][0] ;
            }
            while(idx < tasks.length && endTime >= tasks[idx][0]){
                minHeap.add(tasks[idx]) ;
                ++idx ;
            }
            
            int[] taskToPerform = minHeap.remove();
            sequence.add(indices.get(taskToPerform));
            endTime += taskToPerform[1];         
        }

        return sequence.stream().mapToInt(i->i).toArray() ;
    }
}