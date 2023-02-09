package programmers.lv0;
// 2023. 02. 09
// 120893
public class 대문자와_소문자 {
    public String solution(String my_string) {
        char[] chArr = my_string.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            int gap = 'a' - 'A';

            if (chArr[i] >= 'a' && chArr[i] <= 'z') {
                chArr[i] -= gap;
            } else {
                chArr[i] += gap;
            }
        }

        return String.valueOf(chArr);
    }
}
