package year2023.month01;

class Day20_3 {
    public int solution(int n, int k) {
        return (n * 12000) + (k * 2000) - ((n / 10) * 2000);
    }
}
