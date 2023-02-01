package programmers.lv1;
// 2023. 01. 27
// 12922
public class 수박수박수박수박수박수 {
    public String solution(int n) {
        return new String(new char [n/2+1]).replace("", "수박").substring(0,n);
    }
}
