import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
    백준 18870번 좌표 압축
    분류: 정렬, 값/좌표 압축
    문제: N개의 좌표가 있다.
        좌표 압축으로 Xi의 좌표 압축한 결과인 X'i를 구해야 하는다.
        X'i == Xi보다 작은 서로 다른 수의 개수
        N개의 좌표의 좌표 압축 결과를 구해서 출력하라.

    입력: 라인1 좌표의 개수 N(1 ≤ N ≤ 100,0000)
        라인2 X1 X2 ... XN (-10^9 ≤ Xi ≤ 10^9)

    출력: 각 좌표의 압축 결과 X'1 X'2 ... X'N

    예제 입력1:
        5
        2 4 -10 4 -9
    풀이: TreeSet과 배열을 사용하고, TreeSet을 배열로 바꿔서 바이너리 서치로 위치를 찾을 것
    예제 출력1:
        2 3 0 3 1
 */

public class Main {

    static StringBuilder sb;
    static int[] arr;
    static Integer[] setArr;

    public static void main(String[] args) throws IOException {     // (O(3n + log n)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // O(n)
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {  // O(n)
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        setArr = set.toArray(Integer[]::new);       // O(n)?
        set.clear();
        sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            binarySearch(i);        // O(log n)
        }

        System.out.println(sb);
        br.close();
    }

    public static void binarySearch(int cur) {
        int start = 0;
        int end = setArr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (setArr[mid].equals(arr[cur])) { // 중복을 제거한 배열에서 현재 좌표와 같은 값을 찾으면
                sb.append(mid).append(' '); // 오름차순 정렬을 했으므로 인덱스 값이 현재 좌표값보다 작은 좌표의 개수
                return;
            } else if (arr[cur] > setArr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}