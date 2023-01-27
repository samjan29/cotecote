package year2023.month01;

public class Day27_8 {
    public String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");
        for (int j = 0; j < strArr.length; j++) {
            StringBuilder sb = new StringBuilder(strArr[j]);
            System.out.println(sb);

            for (int i = 0; i < sb.length(); i++) {
                if (i % 2 == 0) {
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                } else {
                    sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                }
            }

            if (j == strArr.length - 1) answer += sb;
            else answer += sb + " ";
        }

        int count = s.length() - answer.length();

        return answer + " ".repeat(count);
    }
}
