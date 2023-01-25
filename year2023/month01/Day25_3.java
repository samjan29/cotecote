package year2023.month01;

public class Day25_3 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int numer3 = (numer1 * denom2) + (numer2 * denom1);
        int denom3 = denom1 * denom2;

//         // 유클리드 호제법
//         int gcd = 1;

//         gcd = gcd(numer3, denom3);

//         answer[0] = numer3 / gcd;
//         answer[1] = denom3 / gcd;

        int i = 2;
        int gcd = 1;

        while (i <= (numer3 > denom3 ? denom3 : numer3)) {
            if (numer3 % i == 0 && denom3 % i == 0) {
                numer3 /= i;
                denom3 /= i;
                gcd *= i;
            } else i++;
        }

        answer[0] = ((numer1 * denom2) + (numer2 * denom1)) / gcd;
        answer[1] = (denom1 * denom2) / gcd;

        return answer;

    }


    // int gcd(int p, int q) {
    //     if (q == 0) return p;
    //     return gcd(q, p%q);
    // }
}
