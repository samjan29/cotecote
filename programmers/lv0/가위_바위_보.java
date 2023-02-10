package programmers.lv0;

public class 가위_바위_보 {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder(rsp.length());

        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '2') sb.append("0");
            else if (rsp.charAt(i) == '0') sb.append("5");
            else sb.append("2");
        }

        return sb.toString();
    }
}
