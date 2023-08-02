class Solution {
    public long solution(int price, int money, int count) {
        long usageCharge = 0;
        
        for (int i = 1; i <= count; i++) {
            usageCharge += price * i;
        }

        long shortfall = money - usageCharge;
        
        return shortfall < 0 ? -shortfall : 0;
    }
}