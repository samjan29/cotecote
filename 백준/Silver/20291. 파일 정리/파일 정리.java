import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String str = br.readLine();
            String extension = str.substring(str.indexOf('.') + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
            N--;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i)).append(" ").append(map.get(list.get(i))).append("\n");
            bw.write(sb.toString());
            sb.setLength(0);
        }
        
        br.close();
        bw.flush();
        bw.close();
    }

}