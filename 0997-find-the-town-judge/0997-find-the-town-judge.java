class Solution {
    public int findJudge(int n, int[][] trusts) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] trust : trusts){
            set.add(trust[0]);
            map.put(trust[1],map.getOrDefault(trust[1],0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key)==n-1 && !set.contains(key)) return key ;
        }
        return trusts.length==0 && n==1 ? 1 : -1 ;
    }
}