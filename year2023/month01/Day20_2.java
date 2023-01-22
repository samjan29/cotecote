package year2023.month01;

class Day20_2 {
    public int solution(int[] dot) {
        if (dot[0] > 0 && dot[1] > 0) return 1;
        else if (dot[0] > 0 && dot[1] < 0) return 4;
        else if (dot[0] < 0 && dot[1] < 0) return 3;
        else return 2;
    }
}
