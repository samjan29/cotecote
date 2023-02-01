package programmers.lv1;
// 2023. 01. 27
// 12901
public class P_2016년 {
    public String solution(int a, int b) {
        int[] lastDateInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int count = b;

        for (int i = 0; i < a - 1; i++) {
            count += lastDateInMonth[i];
        }

        return dayOfWeek[(count - 1) % 7];
    }
}
