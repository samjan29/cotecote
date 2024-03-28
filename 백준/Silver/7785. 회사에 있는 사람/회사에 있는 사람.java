import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        list.sort(Collections.reverseOrder());
        for (String str : list) {
            System.out.println(str);
        }
        
        br.close();
    }

}