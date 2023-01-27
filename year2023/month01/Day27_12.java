package year2023.month01;

public class Day27_12 {
    public long solution(long n) {
        long answer = 0;

        // 배열 길이 구하기
        int count = 0;
        long n2 = n;
        while (n2 > 0) {
            n2 /= 10;
            count++;
        }

        // 배열에 각 자리 수 넣기
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (n % 10);
            n /= 10;
        }

        // 배열 내림차순 정렬
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++)
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

        // 값 리턴
        for (int num : arr) {
            answer *= 10;
            answer += num;
        }

        return answer;
    }
}
