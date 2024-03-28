import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null) {
            set.add(Integer.parseInt(input) % 42);
        }

        System.out.println(set.size());

        br.close();
    }

}