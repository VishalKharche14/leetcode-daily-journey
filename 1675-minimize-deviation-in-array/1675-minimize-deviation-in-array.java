class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.stream(nums).boxed().map(i -> (i & 1) == 1 ? i << 1 : i).toList());

        int ans = Integer.MAX_VALUE;
        while(true){
            int max = set.last();
            ans = Math.min(ans,max-set.first());
            if((max&1) == 1) break;
            else{
                set.remove(max);
                set.add(max>>1);
            }
        }
        return ans ;
    }
}