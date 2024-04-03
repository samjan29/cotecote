import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
        VPS : 괄호 문자열
        e.g., (())() ((()))
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] arr = new String[T];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < T; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                // stack에 '('를 넣고, ')'를 만나면 pop
                if (c == '(') {
                    stack.push(c);
                } else if (!stack.isEmpty() && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                    break;
                }
            }
            // stack이 비어있으면 YES, 아니면 NO
            if (stack.isEmpty()) {
                arr[i] = "YES";
            } else {
                arr[i] = "NO";
            }
            // stack 초기화
            stack.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}