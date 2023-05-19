class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        System.arraycopy(num_list, 0, answer, 0, num_list.length);
        
        int lastEl = num_list[num_list.length - 1];
        int preLastEl = num_list[num_list.length - 2];
        
        answer[answer.length - 1] = lastEl > preLastEl ? lastEl - preLastEl : lastEl * 2;
        
        return answer;
    }
}