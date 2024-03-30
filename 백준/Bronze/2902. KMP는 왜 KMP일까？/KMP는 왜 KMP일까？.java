import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);  // 첫 글자는 항상 대문자
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '-') {
                sb.append(arr[i + 1]);  // 하이픈 뒤에는 반드시 대문자
            }
        }

        System.out.println(sb);
    }
}