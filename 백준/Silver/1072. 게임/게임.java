import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 1072번 게임
    분류: 이분 탐색
    문제: 게임 플레이 X번 중 Y번 이겼고, 승률은 Z (Z의 소수점은 버린다)
        Z가 변하려면 최소 몇판 해야 하는지?

    입력: X(게임을 한 횟수, 1 ≤ X ≤ 10,0000,0000) Y(이긴 게임 수, 0 ≤ Y ≤ X)

    출력: 절대 변하지 않는다면 -1, 변할 수 있는 경우 최소 더 이겨야 하는 게임 수

    풀이: X는 Y가 증가할 때 같이 증가할 것
        이분 탐색으로 찾을 경우
        한번 이겨도 증가할 수 가정하에 start는 1번,
        증가하려면 총게임 수만큼 이겨야 한다는 가정하에 end는 X
        그래서 mid로 X + mid를 나눴을 때 퍼센트가 Y / X + 1보다 높거나 같은 것 중 가장 작은지

        (Y + mid) / (X + mid) > Y / X + 1 일 때 end로 걸러야 함
        근데 >만 하면 같을 때 start = mid가 되어서 최솟값이 잡히지 않음

        start와 end 둘 다 소수점을 버린 값이 Y / X + 1일 수 있기 때문에 mid를 저장해줌
        -> end = mid는 맞는 판단이지만 start = mid는 원하는 승률보다 mid만큼 더 승리 했을 때 구한 승률이 낮기 때문에 mid + 1 해야 함

        start와 end가 같아지면 정답이므로 <=말고 <로 반복문 조건을 걸었음
        종료 조건문이 없고 가능한 최솟값을 구해야 하기 때문에 <=를 사용했을 때 무한반복문이 됨

    -1이 나오는 경우
        총 게임 수와 승리한 게임 수가 같은 경우
        승률이 99퍼 이상인 경우

        98퍼인 경우는 98 / 100으로 계산해봤는데 198 / 200 일 때 99% 됐다!

    4%에서 틀림
    반례 50 29
    오답 1
    정답 2
    부동 소수점 수의 정밀도 문제!!
    그냥 나눴을 때는 0.58이 나오지만 100을 곱하면 57.9999999로 정밀도 문제가 발생
    해결: Y에 100을 곱해서 나중에 100을 곱해서 소수점 오류가 나지 않게 + 100을 곱하면 int 범위를 넘어가기 때문에 long 타입으로 변경
 */
public class Main {

    static long X;
    static long Y;
    static double nowPercent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        X = Long.parseLong(split[0]);
        Y = Long.parseLong(split[1]) * 100L;
        nowPercent = Math.floor((double) Y / X)  + 1.0;
        final double v = (double) Y / X;

        if (nowPercent >= 100.0) {  // 위에서 + 1 해놔서 조건이 100.0보다 크면
            System.out.println(-1);
            return;
        }

        binarySearch();

        br.close();
    }

    public static void binarySearch() {
        long start = 1;
        long end = X;

        while (start < end) {
            long mid = (start + end) / 2;
            double exPercent = Math.floor((double) (Y + mid * 100L) / (X + mid));

            if (nowPercent <= exPercent) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}