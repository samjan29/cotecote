import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
/*
 문제:
 같은 부피가 A,B,C 리터인 세개의 물통이 있다.
 처음 앞 두 물통은 비어있고.
 세번째 물통 C는 가득 차있다.
 이때 한 물통이 비거나 다른 한 물통이 가득찰때까지 부울수 있다.
 
 해당 과정을 거치다보면
 기존 가득차있던 C물통의 양이 변할수 있다.
 첫번째 물통 A가 비어있을때 세번째물통 C에 담겨있을수 있는 물의양을 모두 구하라.
 


 
접근방식
물의 옮기는 방식은 한 물통이 비거나 다른 물통이 가득찰때까지 가능하다.
C에서 B에게 물을 다부으면 B는 9 C는 1
C에서 A에게 물을 다붇고 A->B로 물을다부으면 C는 2
C에서 B에게 물을다붇고 B->A에게물을 다붇고 A에서 C에게 물을 다부으면 C는 9
C에서 B에게 물을다붇고 B->A에게물을 다붇고 B에서 C에게 물을 다붇고 A에서 B에게 물을 다부으면 C는8
C에서 A에게 물을 다붇고 A->C로 다부으면 C는 10
C에서 시작해서 A,B에게 주고 A는 B와 C에게 B는 A와 C에게 주니
A->B
A->C
B->C
B->A
C->A
C->B 로 구성한다?

14740	148
 */
	
	
	static int[] buket = new int[3];
	static TreeSet<Integer> result= new TreeSet<>();//답을 담기위한 셋
	static boolean[][] visit = new boolean[201][201]; //A,B방문여부
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) {
			buket[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0,0,buket[2]);
		for(int num:result) {
			System.out.print(num+" ");
		}
	}
	
	public static void DFS(int AL,int BL,int CL) {
		
		if(visit[AL][BL]==true) return;
		
		if(AL==0) {//A가 0일떄 C의 물량이 출력물
			result.add(CL);
		}
		visit[AL][BL]=true;
		//A->B
		if(AL+BL>buket[1]) {
			DFS((AL+BL)-buket[1],buket[1],CL);
		}else {
			DFS(0,AL+BL,CL);
		}
		//B->A
		if(AL+BL>buket[0]) {
			DFS(buket[0],(AL+BL)-buket[0],CL);
		}else {
			DFS(AL+BL,0,CL);
		}
		//C->A
		if(AL+CL>buket[0]) {
			DFS(buket[0],BL,(AL+CL)-buket[0]);
		}else {
			DFS(AL+CL,BL,0);
		}
		//C->B
		if(BL+CL>buket[1]) {
			DFS(AL,buket[1],(BL+CL)-buket[1]);
		}else {
			DFS(AL,BL+CL,0);
		}
		//물이 넘칠일이 없기때문에 C관련 방문배열 및 if~else로직 필요없음
		//A->C 
		DFS(AL,0,BL+CL);
		//B->C
		DFS(0,BL,AL+CL);
	}

}
