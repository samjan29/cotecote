package programmers.lv1;
// 2023. 01. 27
// 68935
public class P_3진법_뒤집기 {
    public int solution(int n) {
        // 3진법 : 1 => 1, 10 => 3, 100 => 9, 1000 => 27
        String ternary = Integer.toString(n, 3);
        String reverseTernary = new StringBuilder(ternary).reverse().toString();
        return Integer.parseInt(reverseTernary, 3);
    }
}
