import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 1260번 DFS와 BFS
    문제: DFS와 BFS 둘 다 구현해서
        방문할 수 있는 정점이 여러개인 경우 오름차순으로 방문
        더 이상 방문할 수 없으면 종료
        정점의 번호는 1번부터 N번까지

    입력: 라인1 정점의 개수 N(1 ≤ N ≤ 1,000) 간선의 개수 M(1 ≤ M ≤ 10,000) 탐색을 시작할 정점의 번호 V
        라인2부터 M개 만큼 간선으로 연결된 정점

        두 정점 사이에 여러개의 간선이 있을 수 있다고?? => 근데 정점 중복 가능이라는 말은 없고 종료 조건도 없음
        간선은 양방향

    출력: dfs 결과
        bfs 결과

    풀이:

 */
public class Main {
    
    static int N;
    static int M;
    static TreeSet<Integer>[] connected;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        int V = Integer.parseInt(split[2]);
        connected = new TreeSet[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < connected.length; i++) {
            connected[i] = new TreeSet<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {   // O(n)
            st = new StringTokenizer(br.readLine());    // O(n)
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a].add(b);
            connected[b].add(a);
        }

        dfs(V, 0);
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int vertex, int depth) {
        if (depth == N) {
            return;
        }

        visited[vertex] = true;
        sb.append(vertex).append(' ');

        for (int connectedVertex : connected[vertex]) {
            if (!visited[connectedVertex]) {
                dfs(connectedVertex, depth + 1);
            }
        }
    }

    public static void bfs(int vertex) {
        visited[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        sb.append(vertex).append(' ');

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int connectedVertex : connected[now]) {
                if (!visited[connectedVertex]) {
                    visited[connectedVertex] = true;
                    queue.offer(connectedVertex);
                    sb.append(connectedVertex).append(' ');
                }
            }
        }
    }
}