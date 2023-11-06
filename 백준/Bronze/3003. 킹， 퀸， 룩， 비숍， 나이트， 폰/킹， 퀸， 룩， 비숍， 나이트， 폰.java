import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int[] chessPieces = {1, 1, 2, 2, 2, 8};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < chessPieces.length; i++) {
            int input = scanner.nextInt();
            System.out.print((chessPieces[i] - input));

            if (i != chessPieces.length - 1) {
                System.out.print(" ");
            }
        }
    }
    
}
