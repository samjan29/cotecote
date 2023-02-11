class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                Loop:
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    for (int l = 2; l * l <= sum; l++) {
                        if (sum % l == 0) continue Loop;
                    }
                    
                    // 반복문 안에 answer++ 넣어서 l이 약수가 아닐 때도 count되서 안되던 것
                    answer++;
                }

        return answer;
    }
}