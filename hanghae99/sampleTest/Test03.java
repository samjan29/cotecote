package hanghae99.sampleTest;
// 2023. 01. 31
public class Test03 {
    public String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");

        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (Integer.parseInt(strArr[i]) > Integer.parseInt(strArr[j])) {
                    String tmp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = tmp;
                }
            }
        }

        Loop:
        for (String str : strArr) {
            int numStr = Integer.parseInt(str);
            for (int i = 2; i * i <= numStr; i++) {
                if (numStr % i == 0) {
                    answer = str;
                    break Loop;
                }
            }
        }

        Loop:
        for (int i = strArr.length - 1; i >= 0; i--) {
            int numStr = Integer.parseInt(strArr[i]);
            for (int j = 2; j * j <= numStr; j++) {
                if (numStr % j == 0) continue Loop;
            }

            answer += " " + strArr[i];
            break;  // 여기서 break; 안 해주면 다른 소수들 까지 추가 됨
        }

        return answer;
    }

    public static void main(String[] args) {
        Test03 method = new Test03();
        String s = "97 75 88 99 95 92 73";
        System.out.println(method.solution(s));
        System.out.println(method.solution("2 3 4 5"));
        System.out.println(method.solution("15 3 10 9 7 8"));
    }
}
