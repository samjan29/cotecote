package hanghae99.algorithmTest;

public class Test01 {
    public int solution(int num) {
        int answer = 0;

        int[] denomination = {500, 100, 50, 10};
        int change = 1000 - num;

        for (int i = 0; change > 0 ; i++) {
            if (i == 4) break;  // 혹시 모르니까!

            if (change >= denomination[i]) {    // 화폐 단위랑 같아도 가능
                answer += change / denomination[i];
                change %= denomination[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test01 method = new Test01();
        int num1 = 160;
        System.out.println(method.solution(num1));
        System.out.println(method.solution(900));
        System.out.println(method.solution(550));
        System.out.println(method.solution(320));
    }
}
