import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 24444번 알고리즘 수업 - 너비 우선 탐색 1
    문제: N개의 정점과 M개의 간선으로 이루어진 무방향 그래프
        모든 간선의 가중치는 1
        정점 R에서 시작해서 너비 우선 탐색으로 노드를 방문할 때 노드의 방문 순서를 출력

    입력: 라인1 정점의 개수 N(5 ≤ N ≤ 100,000) 간선의 수 M (1 ≤ M ≤ 200,000) 시작 정점 R (1 ≤ R ≤ N)
        라인2부터 간선의 정보 u v (1 ≤ u < v ≤ N, u ≠ v) => 정점 u와 정점 v가 연결되어 있다

    출력: i번째 줄에는 정점 i의 방문 순서

    풀이: 의사 코드 따라하기

    idx를 dfs 내에서 +1에서 인자로 넘겼더니 R의 자식1의 막힌 곳까지 탐색했다가 R로 돌아와 다른 자식을 탐색할 경우 1번 인덱스에 덮어씌워지는 문제 발생
 */
public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] connected;
    static int[] vertexArr;
    static int N;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int R = Integer.parseInt(split[2]); // 시작 정점

        // 인덱스를 정점 번호로 할 것
        visited = new boolean[N + 1];
        vertexArr = new int[N + 1];

        /*
            오름차순과 시간복잡도를 위해 더 나은 자료구조는 어떤 것을 사용해야 할까?
         */
        connected = new ArrayList[N + 1];   // 노드(배열의 인덱스)마다 연결된 노드 넣을 수 있게(ArrayList)
        for (int i = 0; i < connected.length; i++) {
            connected[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            connected[u].add(v);    // 양방향이라서
            connected[v].add(u);    // 이렇게 할 수 있는 것
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(vertexArr[i]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    /*
        bfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
            for each v ∈ V - {R}
                visited[v] <- NO;
            visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
            enqueue(Q, R);  # 큐 맨 뒤에 시작 정점 R을 추가한다.
            while (Q ≠ ∅) {
                u <- dequeue(Q);  # 큐 맨 앞쪽의 요소를 삭제한다.
                for each v ∈ E(u)  # E(u) : 정점 u의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
                    if (visited[v] = NO) then {
                        visited[v] <- YES;  # 정점 v를 방문 했다고 표시한다.
                        enqueue(Q, v);  # 큐 맨 뒤에 정점 v를 추가한다.
                    }
            }
        }
     */

    public static void dfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        vertexArr[vertex] = idx;

        while (!queue.isEmpty()) {
            if (idx == N + 1) {
                return;
            }

            int u = queue.poll();
            Collections.sort(connected[u]);
            for (int v : connected[u]) {  // 오름차순 정렬된 ArrayList
                if (!visited[v]) {
                    visited[v] = true;
                    idx++;
                    vertexArr[v] = idx;
                    queue.offer(v);
                }
            }
        }
    }
}