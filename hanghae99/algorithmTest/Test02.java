package hanghae99.algorithmTest;

public class Test02 {
    public int solution(String s) {
        int answer = 0;

        char[] charArr = s.toCharArray();

        int continuity = 0;
        for (char ch : charArr) {
            if (ch == 'X') continuity = 0;
            else {
                answer += continuity++ + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test02 method = new Test02();
        String s = "OXOOOXXXOXOOXOOOOOXO";
        System.out.println(method.solution(s));
        System.out.println(method.solution("OOXXOXXOOO"));
        System.out.println(method.solution("OXOXOXOXOXOXOX"));
        System.out.println(method.solution("OOOOOOOOOO"));
    }
}
