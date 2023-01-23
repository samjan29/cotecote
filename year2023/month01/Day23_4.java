package year2023.month01;

public class Day23_4 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1 + 1];

        int idx = 0;
        for (int i = num1; i <= num2; i++, idx++)
            answer[idx] = numbers[i];

        return answer;
    }
}
