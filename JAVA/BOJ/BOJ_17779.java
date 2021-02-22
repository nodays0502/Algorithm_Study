package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779 {
	static int n ;
	static int input[][];
	static int divide[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int result = Integer.MAX_VALUE ;
	static void perm(int y, int x , int d1, int d2) {
		divide = new int[n+1][n+1];
		divide[y][x] = 5;
		if(y + d2> n || x+d2+d1 > n ||y - d1 + 1 <=0 ) {System.out.println(y+" "+x+" "+d1+" "+d2);return;}
		/*(x, y), (x+1, y-1), ..., (x+d1, y-d1)
		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		 * */
		for(int i = 1 ; i <= d1 ; i++) { // 경계선 1 , 4
			divide[y - i][x + i] = 5; // 경계선1
			divide[y + d2 - i][x + d2 + i] = 5; // 경계선 4
		}
		for(int i = 1 ; i <= d2 ; i++) { // 경계선 2 , 3
			divide[y + i][x + i] = 5; // 경계선 2
			divide[y - d1 + i][x + d1 + i] = 5; // 경계선 3
		}
		//--------------------------------------------
		for(int i = 1 ; i < y; i ++) { // 1구역
			for(int j = 1 ; j <= x + d1 ; j++) {
				if(divide[i][j] == 5) break;
				divide[i][j] = 1;
			}
		}/*
		1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
		2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
		3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		*/
		for(int i = y  ; i <= n; i ++) { // 2구역
			for(int j = 1 ; j < x+d2 ; j++) {
				if(divide[i][j] == 5) break;
				divide[i][j] = 2;
			}
		}
		for(int i = 1 ; i <= y-d1+d2; i++) {  // 3구역
		//	for(int j = x+d1+1 ; j <= n ; j++) {
			for(int j = n ; j >=x+d1+1; j--) {
				if(divide[i][j] == 5) break;
				divide[i][j] = 3;
			}
		}
		for(int i = y-d1+d2+1 ; i <= n; i ++) { // 4구역
		//	for(int j = x + d2 ; j <= n ; j++) {
			for(int j = n ; j >=x + d2 ; j--) {
				if(divide[i][j] == 5) break;
				divide[i][j] = 4;
			}
		}
		
		cal();
	}

	static void cal() {

		int[] sum = new int[6];
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++ ) {
				if(divide[i][j] == 0)divide[i][j] = 5;
				sum[divide[i][j]] += input[i][j];
			}
		}
		int max = sum[1];
		int min = sum[1];
		for(int i = 2 ; i < 6 ; i++) {
			max = Math.max(max, sum[i]);
			min = Math.min(min, sum[i]);
		}
//		System.out.println(max+" "+min);
		result = Math.min(result, max-min);
	}
	static void print() {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				System.out.print(divide[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n+1][n+1];

		for(int i = 1 ; i <= n ; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for(int j = 1 ; j <= n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int y = 1 ; y <= n ; y++) { // y
			for(int x = 1 ; x <= n ; x++) { // x
				for(int d1 = 1 ; d1 < n  ; d1++) { // d1
					for(int d2 = 1 ; d2 < n ; d2++) { // d2
						if(x+d1+d2 <= n && 1 <= y-d1 && y+d2 <= n) { // (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
						//	perm(4,2,1,1);
							perm(y,x,d1,d2);
						}
					}
				}
			}
		}
		System.out.println(result);
	}

}
