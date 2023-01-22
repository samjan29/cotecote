package year2023.month01;

class Day22_1 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++)
            answer[i] = num_list[num_list.length - 1 - i];

        return answer;
    }
}
