class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>() ;
        int carry = 0 ;
        int idx = num.length-1;
        while(idx>=0 || k > 0 || carry > 0){
            int sum = (k%10)+carry ;
            if(idx>=0) sum += num[idx--] ;
            k/=10 ;
            carry = sum/10 ;
            sum %= 10 ;
            list.add(sum) ;
        }
        Collections.reverse(list);
        return list ;
    }
}