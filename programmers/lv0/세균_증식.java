package programmers.lv0;
// 2023. 02. 07
// 120910
public class 세균_증식 {
    public int solution(int n, int t) {
        for (int i = 1; i <= t; i++)
            n *= 2;

        return n;
    }
}
