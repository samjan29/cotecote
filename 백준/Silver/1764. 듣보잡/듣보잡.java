import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<String> answerSet = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        Set<String> hashSet = new HashSet<>();
        int len = Integer.parseInt(arr[0]);
        while (len > 0) {
            hashSet.add(br.readLine());
            len--;
        }

        len = Integer.parseInt(arr[1]);
        while (len > 0) {
            String str = br.readLine();
            if (hashSet.contains(str)) {
                answerSet.add(str);
                hashSet.remove(str);
            }
            len--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answerSet.size());
        for (String str : answerSet) {
            sb.append("\n").append(str);
        }
        System.out.println(sb);

        br.close();
    }
}