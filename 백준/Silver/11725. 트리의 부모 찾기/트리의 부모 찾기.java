import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    백준 11725번 트리의 부모 찾기
    문제: 루트가 없는 트리 -> 근데 루트가 1임 => 루트는 1밖에 없다는 것?? 뒤죽박죽으로 들어온다는 것??
            node == vertex

    입력: 라인1 노드의 개수 N (2 ≤ N ≤ 10,0000)
        라인2부터 N-1개의 줄에 트리 상에서 연결된 두 정점
        N-1인 이유가 루트인 1에 연결된 간선이 없어서?
        왼쪽이 항상 부모 노드가 아니라는 것 주의

    출력: 각 노드의 부모 노드를 한줄마다 출력
        부모가 있는 2번 노드부터!

    풀이: ??
 */
public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] connected;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        connected = new ArrayList[N + 1];   // 노드(배열의 인덱스)마다 연결된 노드 넣을 수 있게(ArrayList) 
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            connected[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a].add(b);    // 연결된 경우 무조건 서로에게 넣어주기
            connected[b].add(a);
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {  // 2번 노드부터 부모 노드를 출력하는 것이 조건
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int node, int parent) {
        visited[node] = true;   // 1의 부모는 없기 때문에 방문 처리를 해도 됨
        parents[node] = parent; // 1의 부모가 없디 때문에 0으로 저장

        for (int n : connected[node]) { // node와 연결된 노드를 꺼내서
            if (!visited[n]) {  // dfs인 이유 => 루트 1기준으로 1의 자식 중 하나부터 깊이 들어갔다가 나오고 다음 자식을 방문
                dfs(n, node);
            }
        }
    }
}