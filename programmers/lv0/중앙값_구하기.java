package programmers.lv0;
// 2023. 01. 22
// 120811
public class 중앙값_구하기 {
    public int solution(int[] array) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array[array.length / 2] ;
    }
}
