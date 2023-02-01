package programmers.lv2;
// 2023. 01. 31
// 12939
public class 최댓값과_최솟값 {
    public String solution(String s) {
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

        StringBuilder sb = new StringBuilder(3);
        sb.append(strArr[0]);
        sb.append(" ");
        sb.append(strArr[strArr.length - 1]);

        return sb.toString();
    }
}
