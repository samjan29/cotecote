package year2023.month01;

public class Pizza20 {
    public int solution(int n) {
        return n % 7 == 0 ? n / 7 : n / 7 + 1;
    }
}
