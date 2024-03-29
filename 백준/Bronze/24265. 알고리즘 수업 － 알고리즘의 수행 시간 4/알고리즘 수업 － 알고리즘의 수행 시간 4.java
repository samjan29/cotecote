import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
        n <- 7
        MenOfPassion(A[], n) {
            sum <- 0;
            for i <- 1 to n - 1     => 6
                for j <- i + 1 to n => O(6 + 5 + 4 + 3 + 2 + 1) => 등차수열 O(n(n-1)/2)
                    sum <- sum + A[i] × A[j]; # 코드1
            return sum;
        }

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        long count = n * (n - 1) / 2;
        System.out.println(count);
        int degree;
        if (count >= Math.pow(n, 4)) {
            degree = 4;
        } else if (count >= Math.pow(n, 3)) {
            degree = 3;
        } else {
            degree = 2;
        }
        System.out.println(degree);

        br.close();
    }

}