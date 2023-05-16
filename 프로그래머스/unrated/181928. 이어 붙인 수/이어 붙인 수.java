class Solution {
    public int solution(int[] num_list) {
        int even = 0, odd = 0;
        
        for(int num : num_list) {
           if(num % 2 == 0) {
               even = even * 10 + num;
           } else {
               odd = odd * 10 + num;
           }
        }
        
        return even + odd;
    }
}