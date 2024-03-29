import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> nMap = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (N > 0) {   // 50만
            int tmp = Integer.parseInt(st.nextToken());
            nMap.put(tmp, nMap.getOrDefault(tmp, 0) + 1);
            N--;
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            Integer result = nMap.get(arr[i]);
            if (result == null) result = 0;
            bw.write(String.valueOf(result));
            
            if (i != arr.length - 1) {
                bw.write(" ");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }

}