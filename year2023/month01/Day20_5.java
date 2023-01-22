package year2023.month01;

class Day20_5 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 0; i < n / 2; i++) {
            if (n % 2 == 0) {
                answer += n - 2 * i;
            } else {
                answer += n - 2 * i - 1;
            }
        }

        return answer;
    }
}
