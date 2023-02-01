package programmers.lv0;
// 2023. 01. 23
// 120824
public class 짝수_홀수_개수 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int num : num_list) {
            if (num % 2 == 0) answer[0]++;
            else answer[1]++;
        }

        return answer;
    }
}
