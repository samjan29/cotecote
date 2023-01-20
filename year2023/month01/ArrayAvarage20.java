package year2023.month01;

public class ArrayAvarage20 {
    public double solution(int[] numbers) {
        double answer = 0;

        for (int number : numbers) {
            answer += number;
        }

        return answer / numbers.length;
    }
}
