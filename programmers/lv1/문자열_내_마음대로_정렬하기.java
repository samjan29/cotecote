package programmers.lv1;
// 2023. 01. 28
// 12915
public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        // 순서 비교
        for (int i = 0; i < strings.length; i++)
            for (int j = i + 1; j < strings.length; j++)
                if (strings[i].charAt(n) > strings[j].charAt(n)) {
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    // strings[i]가 사전적으로 strings[j] 보다 크다면
                    if (strings[i].compareTo(strings[j]) > 0) {
                        String tmp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }

        return strings;
    }
}
