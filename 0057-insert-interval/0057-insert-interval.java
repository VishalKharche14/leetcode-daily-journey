class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int []> list = new ArrayList();
        
        for(int[] arr: intervals){
            if(arr[1]<newInterval[0]){
                list.add(arr);
            }
            else if (newInterval[1]<arr[0]){
                list.add(newInterval);
                newInterval=arr;
            }
            else{
                newInterval[0]=Math.min(newInterval[0],arr[0]);
                newInterval[1]=Math.max(newInterval[1],arr[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int [0][]);
    }
}