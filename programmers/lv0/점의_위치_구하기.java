package programmers.lv0;
// 2023. 01. 20
// 120841
class 점의_위치_구하기 {
    public int solution(int[] dot) {
        if (dot[0] > 0 && dot[1] > 0) return 1;
        else if (dot[0] > 0 && dot[1] < 0) return 4;
        else if (dot[0] < 0 && dot[1] < 0) return 3;
        else return 2;
    }
}
