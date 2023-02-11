import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        // 일단 가장 긴 변 찾기
        int longSide = 0;
        int idx = 0;
        for (int i = 0; i < sides.length; i++) {
            if (longSide < sides[i]) {
                longSide = sides[i];
                idx = i;
            }
        }

        switch(idx) {
            case 0:
                if (sides[1] + sides[2] > longSide) return 1;
                else return 2;
            case 1:
                if (sides[0] + sides[2] > longSide) return 1;
                else return 2;
            case 2:
                if (sides[0] + sides[1] > longSide) return 1;
                else return 2;
        }

        return 0;
    }
}