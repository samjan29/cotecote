package year2023.month01;

public class Day27_6 {
    public String solution(int n) {
        return new String(new char [n/2+1]).replace("", "수박").substring(0,n);
    }
}
