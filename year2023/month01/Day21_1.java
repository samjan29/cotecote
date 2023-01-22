package year2023.month01;

class Day21_1 {
    public int solution(int coupon) {
        int service = 0;

        // 쿠폰으로 받을 수 있는 치킨의 수를 구하기
        while (coupon >= 10) {
            service += coupon / 10;
            // 사용했던 쿠폰은 버리고 안 쓴 쿠폰을 저장
            coupon = coupon / 10 + coupon % 10;
        }

        return service;
    }
}
