package year2023.month01;

public class Day22_7 {
    public int solution(int[] array, int n) {
        int answer = 0;

        for (int num : array)
            if (num == n) answer++;

        return answer;
    }
}
