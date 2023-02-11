import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        String ox = "";
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            ox = br.readLine();
            
            char[] charArr = ox.toCharArray();

            int sequence = 0;
            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == 'X') sequence = 0;
                else {
                    score[i] += sequence++ + 1;
                }
            }
            System.out.println(score[i]);
        }
            
        
        br.close();
    }    
}
