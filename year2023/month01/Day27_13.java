package year2023.month01;

public class Day27_13 {
    public long solution(long n) {
        long answer = -1;

        if (Math.sqrt(n) % 1 == 0) return (long) Math.pow(Math.sqrt(n) + 1, 2);

        return answer;
    }
}
