import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double graSum = 0;
        double creSum = 0;

        String input;
        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");

            double credit = Double.parseDouble(arr[1]);
            switch (arr[2]) {
                case "A+":
                    graSum += credit * 4.5;
                    break;
                case "A0":
                    graSum += credit * 4.0;
                    break;
                case "B+":
                    graSum += credit * 3.5;
                    break;
                case "B0":
                    graSum += credit * 3.0;
                    break;
                case "C+":
                    graSum += credit * 2.5;
                    break;
                case "C0":
                    graSum += credit * 2.0;
                    break;
                case "D+":
                    graSum += credit * 1.5;
                    break;
                case "D0":
                    graSum += credit;
                    break;
            }

            if (!arr[2].equals("P")) {
                creSum += credit;
            }
        }

        System.out.printf("%.6f", graSum / creSum);
        br.close();
    }

}