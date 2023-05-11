class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        
        for (int num : num_list) {
            if (n == num) {
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}