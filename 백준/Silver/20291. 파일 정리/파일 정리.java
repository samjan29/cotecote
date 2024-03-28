import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        for (int i = 0; i < size; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(list.get(i)).append(" ").append(map.get(list.get(i)));
            System.out.println(sb.toString());
        }

        br.close();
    }

}