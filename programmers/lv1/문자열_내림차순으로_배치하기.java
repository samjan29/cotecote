package programmers.lv1;
// 2023. 01. 28
// 12917
public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        char[] chArr = s.toCharArray();

        for (int i = 0; i < chArr.length; i++)
            for (int j = i + 1; j < chArr.length; j++)
                if (chArr[i] < chArr[j]) {
                    char tmp = chArr[i];
                    chArr[i] = chArr[j];
                    chArr[j] = tmp;
                }

        return String.valueOf(chArr);
    }
}
