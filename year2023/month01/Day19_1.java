package year2023.month01;

class Day19_1 {
    public int solution(int age) {
        int answer = 0;

        if (age > 0 && age <= 120)
            answer = 2022 - age + 1;

        return answer;
    }
}