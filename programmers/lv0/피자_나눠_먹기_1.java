package programmers.lv0;
// 2023. 01. 20
// 120814
class 피자_나눠_먹기_1 {
    public int solution(int n) {
        return n % 7 == 0 ? n / 7 : n / 7 + 1;
    }
}
