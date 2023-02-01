package programmers.lv0;
// 2023. 01. 26
// 120818
public class 옷가게_할인_받기 {
    public int solution(int price) {
        double answer = 0;

        if (price >= 500000) answer = (price * 0.8);
        else if (price >= 300000) answer = (price * 0.9);
        else if (price >= 100000) answer = (price * 0.95);
        else answer = price;

        return (int) answer;
    }
}
