import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    백준 2108번 통계학
    분류: 구현, 정렬
    문제: N은 항상 홀수, N개의 숫자가 주어지면
        1.산술평균 : N개의 수들의 합을 N으로 나눈 값
        2.중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        3.최빈값 : N개의 수들 중 가장 많이 나타나는 값   (같은 수가 여러개면 두번째 작은 수)
        4.범위 : N개의 수들 중 최댓값과 최솟값의 차이
        위의 네 가지 기본 통계값을 구해서 한줄씩 출력하기

    입력: 라인1 수의 개수 N(1 ≤ N ≤ 50,0000, N은 항상 홀수)
        라인2부터 N개의 숫자가 입력 된다 (-4000 ≤ 숫자 ≤ 4000)

    출력: 네 가지 기본 통계값을 순서대로 한줄씩 출력

    풀이: TreeMap을 사용해서 Key를 정렬하고, Key를 List로 뽑고, count가 많이 된 수를 뽑고 ~~

    실패1 N을 KeyList의 size라고 착각해서 예외 발생
        같은 수가 있다는 것을 깜빡해서 발생한 일
    실패2 중복은 map의 value에 카운팅했다는 것을 깜빡해서 cal1 틀림
    실패3 TreeMap을 써서 중복이 없기 때문에 cal2가 실패
    실패4 cal3 로직이 잘못되어서...
 */
public class Main {

    static int N;
    static Map<Integer, Integer> map;
    static List<Integer> keyList;
    static int keyListSize;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        keyList = new ArrayList<>(map.keySet());
        keyListSize = keyList.size();

        int max = cal1();
        cal2();
        cal3(max);
        cal4();

        System.out.println(sb);
        br.close();
    }

    public static int cal1() {  // 산술 평균
        double sum = 0;
        int max = 0;
        for (int i = 0; i < keyListSize; i++) {
            int key = keyList.get(i);
            int val = map.get(key);
            sum += (double) key * val;
            max = Math.max(max, val);
        }
        sb.append(Math.round(sum / N)).append('\n');
        return max;
    }

    public static void cal2() {
        int mid = 0;
        for (int i = 0, temp = -1; i < N; i++) {
            int key = keyList.get(i);
            temp += map.get(key);
            if (temp >= N / 2) {
                mid = key;
                break;
            }
        }
        sb.append(mid).append('\n');
    }

    public static void cal3(int max) { // 최빈값
        if (N == 1) {
            sb.append(keyList.get(0)).append('\n');
            return;
        }

        for (int i = 0, count = 0, idx = 0; i < keyListSize; i++) {
            int temp = map.get(keyList.get(i));

            if (max == temp) {
                idx = i;
                count++;
            }

            if (count == 2 || i == keyListSize - 1) {
                sb.append(keyList.get(idx)).append('\n');
                break;
            }
        }
    }

    public static void cal4() { // 범위
        sb.append(keyList.get(keyListSize - 1) - keyList.get(0));
    }

}