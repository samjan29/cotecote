import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
        MenOfPassion(A[], n) {  n <- 7
            sum <- 0;
            for i <- 1 to n - 2             =>
                for j <- i + 1 to n - 1     => 2 -> O(5), 3 -> O(4), 4 -> O(3), 5 -> O(2), 6 -> O(1)
                    for k <- j + 1 to n     => 3 -> O(5), 4 -> O(4), 5 -> O(3), 6 -> O(2), 7 -> O(1), 4, 5, 6, 7, 5, 6, 7, 6, 7, 7
                                                O((5 + 4 + 3 + 2 + 1) + (4 + 3 + 2 + 1) + (3 + 2 + 1) + (2 + 1) + 1)
                        sum <- sum + A[i] × A[j] × A[k]; # 코드1
            return sum; 뭔소리야
        }
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long count = (n - 2) * (n - 1) * n / 6;
        System.out.println(count);
        System.out.println(3);

        br.close();
    }

}