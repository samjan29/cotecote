import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        int[] result = new int[T];
        Queue<Integer> queue =new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);  // 문서의 개수
            int M = Integer.parseInt(split[1]);  // 궁금한 문서의 위치

            if (N == 1) {
                br.readLine();
                result[i] = 1;
                continue;
            }

            Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {   // 먼저 큐에 문서의 중요도를 다 넣어준다.
                int temp = Integer.valueOf(st.nextToken());
                queue.offer(temp);
                map.put(temp, map.getOrDefault(temp, 0) + 1);   // 중요도가 같은 문서 개수를 저장
            }

            List<Integer> list = new ArrayList<>(map.keySet());
            int keyIdx = 0; // 중요도가 같은 문서 개수를 저장한 map의 key 인덱스
            int idx = M;    // 궁금한 문서의 위치
            int order = 0;  // 몇 번째로 출력되는지 저장
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                int max = list.get(keyIdx);
                if (max > poll && !queue.isEmpty()) {  // 큐에서 꺼낸 문서가 중요도가 가장 높지 않다면
                    queue.offer(poll);
                    if (idx == 0) {
                        idx = N;
                    }
                } else if (queue.isEmpty() || max == poll) {    // 큐에서 꺼낸 문서가 중요도가 가장 높다면
                    N--;
                    order++;
                    map.put(poll, map.get(poll) - 1);   // 중요도가 같은 문서 개수를 감소
                    if (map.get(poll) == 0) {
                        keyIdx++;
                    }
                }

                if (idx == 0) {
                    break;
                }
                idx--;
            }

            result[i] = order;
            queue.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}