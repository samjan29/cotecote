import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    static Pattern pattern = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            if (pattern.matcher(br.readLine()).matches()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }

            if (T >= 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}