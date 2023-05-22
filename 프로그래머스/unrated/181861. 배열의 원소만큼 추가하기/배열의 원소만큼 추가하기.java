class Solution {
    public int[] solution(int[] arr) {
        int sum = 0;        
        for (int number : arr) {
            sum += number;
        }
        
        int[] answer = new int[sum];
        
        int index = 0;
        for (int number : arr) {
            for (int j = 0; j < number; j++, index++) {
                answer[index] = number;
            }
        }
        
        return answer;
    }
}