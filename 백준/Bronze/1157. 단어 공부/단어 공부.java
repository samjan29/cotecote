import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();

        String str = br.readLine().toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char answer = 0;
        int before = 0, sameCnt = 0;
        for (Character key : map.keySet()) {
            int v = map.get(key);

            if (v > before) {
                answer = key;
                before = v;
                sameCnt = 0;
            } else if (v == before) {
                sameCnt++;
            }
        }

        if (sameCnt > 0) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }

        br.close();
    }

}