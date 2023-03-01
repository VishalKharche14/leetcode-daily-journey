class Solution {
    public int[] sortArray(int[] nums) {
        divide(0,nums.length-1,nums);
        return nums;
    }
    public void divide(int start, int end , int []arr){
        if(start>=end) return;

        int mid = start + (end - start)/2;
        //first half
        divide(start,mid,arr);
        //second half
        divide(mid+1,end,arr);
        //conquer part
        merge(start,mid,end,arr);
    }
    public static void merge(int start, int mid, int end, int[]arr){
        int [] merged = new int [end-start+1];

        int p1 = start; //to traverse first part of array
        int p2 = mid+1; //to traverse second part of array
        int p3 = 0; // to traverse newly created merged array

        while(p1<=mid && p2<=end){
            if(arr[p1]<arr[p2]){
                merged[p3++]=arr[p1++];
            }
            else{
                merged[p3++]=arr[p2++];
            }
        }
        //any 1 while loop will work from 2 loops written below in case of uneven size of divided array.
        while(p1<=mid){
            merged[p3++]=arr[p1++];
        }
        while(p2<=end){
            merged[p3++]=arr[p2++];
        }
        //copying elements from merged array to original array
        p3=0;
        for(int i=start; i<=end; i++){
            arr[i]=merged[p3++];
        }
//        System.out.println(Arrays.toString(arr));
    }
}