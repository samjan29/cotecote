package programmers.lv0;
// 2023. 01. 20
// 120817
class 배열의_평균값 {
    public double solution(int[] numbers) {
        double answer = 0;

        for (int number : numbers) {
            answer += number;
        }

        return answer / numbers.length;
    }
}
