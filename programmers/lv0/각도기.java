package programmers.lv0;
// 2023. 01. 19
// 120829
class 각도기 {
    public int solution(int angle) {
        if (angle < 90) return 1;
        else if (angle == 90) return 2;
        else if (angle < 180) return 3;
        else return 4;
    }
}
