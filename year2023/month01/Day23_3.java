package year2023.month01;

public class Day23_3 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int num : num_list) {
            if (num % 2 == 0) answer[0]++;
            else answer[1]++;
        }

        return answer;
    }
}
