package programmers.lv1;
// 2023. 01. 27
// 12934
public class 정수_제곱근_판별 {
    public long solution(long n) {
        long answer = -1;

        if (Math.sqrt(n) % 1 == 0) return (long) Math.pow(Math.sqrt(n) + 1, 2);

        return answer;
    }
}
