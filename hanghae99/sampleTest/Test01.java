package hanghae99.sampleTest;
// 2023. 01. 31
public class Test01 {
    public String solution(int month, int day) {
        String answer = "";

        int[] lastDayEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < month - 1; i++) day += lastDayEachMonth[i];

        day += 98;

        if (day > 365) day -= 365;

        for (int i = 0; i < lastDayEachMonth.length; i++) {
            if (day - lastDayEachMonth[i] < 0) {
                month = i + 1;
                break;
            }

            day -= lastDayEachMonth[i];
        }
//        for (int i = month; ; i++) {
//            System.out.println(month);
//            if (i >= 12) {
//                i = month -= 11;
//                day -= lastDayEachMonth[0] - 1;
//                continue;
//            }
//
//            if (month == 1) {
//                month++;
//                day -= lastDayEachMonth[i - 1] - 1;
//                continue;
//            }
//
//            if (day - lastDayEachMonth[i - 1] < 0) break;
//
//
//            month++;
//            day -= lastDayEachMonth[i - 1];
//        }

        return month + "월 " + day + "일";
    }

    public static void main(String[] args) {
        Test01 method = new Test01();
        System.out.println(method.solution(1, 18));
        System.out.println(method.solution(11, 27));
        System.out.println(method.solution(6, 22));
    }
}

