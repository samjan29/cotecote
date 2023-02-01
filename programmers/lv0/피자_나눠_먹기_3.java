package programmers.lv0;
// 2023. 01. 25
// 120816
public class 피자_나눠_먹기_3 {
    public int solution(int slice, int n) {
        int answer = 0;

        if (n > slice) answer = (n / slice) + (n % slice == 0 ? 0 : 1);
        else answer = 1;

        return answer;
    }
}
