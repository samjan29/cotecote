class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length % n == 0 ? num_list.length / n : num_list.length /n + 1];
        
        int index = 0;
        for(int i = 0; i < num_list.length; i += n) {
            answer[index++] = num_list[i];
        }   
        
        return answer;
    }
}