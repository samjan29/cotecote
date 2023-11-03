import java.util.Scanner;
import java.util.Arrays;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int[] delay = new int[people];
        
        for (int i = 0; i < delay.length; i++) {
            delay[i] = sc.nextInt();
        }
        
        Arrays.sort(delay);
        
        int result = 0;
        for (int i = 0; i < delay.length; i++) {
            for (int j = 0; j <= i; j++) {
                result += delay[j];
            }
        }
        System.out.println(result);
    }
    
}