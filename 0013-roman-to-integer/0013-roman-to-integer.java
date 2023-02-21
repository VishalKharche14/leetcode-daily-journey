class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> roman = new HashMap();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        
        int value = 0;
        
        for(int i=0; i<s.length()-1; i++){
            if(roman.get(s.charAt(i)) >= roman.get(s.charAt(i+1)))
                value += roman.get(s.charAt(i));
            else value -= roman.get(s.charAt(i));    
        }
        value += roman.get(s.charAt(s.length()-1));
        return value;
        
        
//         int[] arr = new int[s.length()];
//         int index=0;
//         for(char ch: s.toCharArray()){
//             arr[index++]=roman.get(ch);
//         }
        
//         int ans = 0;
//         for(int i=0; i<arr.length; i++){
//             if(i<arr.length-1 && arr[i]<arr[i+1]){
//                 ans+=(arr[i+1]-arr[i]);
//                 i++;
//             }
//             else ans+=arr[i];   
//         }
//         return ans;
    }
}