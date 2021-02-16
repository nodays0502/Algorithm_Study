package ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1074 {
	static int squared2[]; // 2의 제곱근을 저장해 두었다.  squared2[i] = 2^i;
	static int N;
	static int smalls[][] = new int[2][2]; // 제일 작은 사작형 길이 = 2
	static int cal(int n,int y,int x) {
		int result = 0;
		if(n == 1) { // 제일 작은 사각형까지 왔다면
			return smalls[y][x];
		}
		// 각각의 어디 사분면에 존재하는지 보고 y값과 x갑 변경
		if(y >= squared2[n-1] && x >= squared2[n-1]) { // 4사분면에 존재한다면 
			y -= squared2[n-1];
			x -= squared2[n-1];
			result += 3 * squared2[n-1]*squared2[n-1]; // 4사분면에 좌표가 존재한다면, 1,2,3사분면의 개수만큼 수를 증가시킨다.
		}else if(y >= squared2[n-1] ) { // 3사분면에 존재한다면
			y -= squared2[n-1];
			result += 2 * squared2[n-1]*squared2[n-1];
		}
		else if(x >= squared2[n-1] ) { // 2사분면에 존재한다면
			x -=squared2[n-1];
			result += squared2[n-1]*squared2[n-1];
		}
//		System.out.println(result);
		result += cal(n-1,y,x);
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
	//	map = new int[(int)Math.pow(2, N)][(int)Math.pow(2, N)];
		squared2 = new int[N+2];
		squared2[0] = 1;
		squared2[1] = 2;
		smalls[0][0] = 0;
		smalls[0][1] = 1;
		smalls[1][0] = 2;
		smalls[1][1] = 3;
		for(int i = 1 ; i <= N ; i++) {
			squared2[i+1] = 2 * squared2[i];
		}
	//	System.out.println(Arrays.toString(squared2));;
		System.out.println(cal(N,y,x));
	}
}
