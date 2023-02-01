package programmers.lv0;
// 2023. 01. 22
// 120847
class 최댓값_만들기_1 {
    public int solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        return numbers[0] * numbers[1];
    }
}
