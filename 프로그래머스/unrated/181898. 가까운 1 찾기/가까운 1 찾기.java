class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        
        for (; idx < arr.length; idx++) {
            if (arr[idx] == 1) {
                answer = idx;
                break;
            }
        }
        
        return answer;
    }
}