import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String str = br.readLine();
            String extension = str.substring(str.indexOf('.') + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
            N--;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            bw.write(sb.toString());
            sb.setLength(0);
        }

        br.close();
        bw.flush();
        bw.close();
    }

}