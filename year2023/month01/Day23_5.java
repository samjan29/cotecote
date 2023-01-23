package year2023.month01;

public class Day23_5 {
    public int solution(int[] array, int height) {
        int answer = 0;

        for (int num : array)
            if (num > height) answer++;

        return answer;
    }
}
