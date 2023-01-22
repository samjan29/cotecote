package year2023.month01;

class Day22_2 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++)
            answer[i] = strlist[i].length();

        return answer;
    }
}
