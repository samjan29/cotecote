class Solution {
    public String solution(int age) {
        StringBuffer sb = new StringBuffer();
        
        while (age > 0) {
            System.out.println(age);
            if (age == 1000) {
                sb.append("baaa");
                age %= 1000;
            } else if (age > 100) {
                int temp = age / 100;
                sb.append((char) ('a' + temp));
                age -= temp * 100;
            } else if (age == 100) {
                sb.append("baa");
                age %= 100;
            } else if (age > 10) {
                int temp = age / 10;
                sb.append((char) ('a' + temp));
                age -= temp * 10;
            } else if (age == 10) {
                sb.append("ba");
                age %= 10;
            } else {
                sb.append((char) ('a' + age));
                age = 0;
            }
        }
        
        return sb.toString();
    }
}