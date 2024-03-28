import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        while (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();

            if (set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }

            n--;
        }

        List<String> list = new ArrayList<>(set);
        set.clear();
        list.sort(Collections.reverseOrder());

        int size = list.size();
        for (int i = 0; i < size; i++) {
            bw.write(list.get(i) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }

}