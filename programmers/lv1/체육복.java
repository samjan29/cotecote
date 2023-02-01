package programmers.lv1;
// 2023. 01. 31
// 42862
import java.util.ArrayList;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // int 배열로 충분한 문제, 굳이 ArrayList를 쓸 필요 없음
        ArrayList<Integer> list = new ArrayList<>(n);

        // 초기화
        for (int i = 0; i < n; i++) list.add(0);

        // 도난 당한 학생 -1
        for (int num : lost) list.set(num - 1, -1);

        // 여벌 있는 학생 + 1
        for (int num : reserve) list.set(num - 1, list.get(num - 1) + 1);

        // 빌려주기
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                continue;
            }

            // 관건은 언제 비교를 해서 값을 변경하는가?
            if (list.get(i) == -1) {
                // 앞부터 비교를 하고 있어서 앞에 여벌이 있는 학생이 있는지 먼저 봐야함
                if (i > 0 && list.get(i - 1) == 1) {
                    list.set(i, 0);
                    list.set(i - 1, list.get(i - 1) - 1);
                } else if (i < list.size() - 1 && list.get(i + 1) == 1) {
                    list.set(i, 0);
                    list.set(i + 1, list.get(i + 1) - 1);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 0) answer++;
        }

        return answer;
    }
}
