import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
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

        for (String str : set) {
            bw.write(str + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}