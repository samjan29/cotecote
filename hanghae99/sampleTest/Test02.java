package hanghae99.sampleTest;
// 2023. 01. 31
public class Test02 {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;

        for (int i = 0; i < arr1.length; i++) {
            int nextDayTime = arr2[i] - 24;
            if (nextDayTime >= 5) {
                answer += 21 - arr1[i];
                continue;
            }

            answer += arr2[i] - arr1[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Test02 method = new Test02();

        // test1
        int[] test1Arr1 = {9, 9, 9, 9, 7, 9, 8};
        int[] test1Arr2 = {23, 23, 30, 28, 30, 23, 23};
        System.out.println(method.solution(test1Arr1, test1Arr2));

        // test2
        int[] test2Arr1 = {9, 9, 8, 8, 7, 8, 9};
        int[] test2Arr2 = {21, 25, 30, 29, 22, 23, 30};
        System.out.println(method.solution(test2Arr1, test2Arr2));

        // test3
        int[] test3Arr1 = {9, 7, 8, 9, 7, 9, 8};
        int[] test3Arr2 = {23, 22, 26, 26, 29, 27, 22};
        System.out.println(method.solution(test3Arr1, test3Arr2));

    }
}
