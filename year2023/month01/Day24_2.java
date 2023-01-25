package year2023.month01;

public class Day24_2 {
    public int[] solution(int n) {
        int[] answer;

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }

        answer = new int[count];

        count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) {
                answer[count] = i;
                count++;
            }

        return answer;
    }
}
