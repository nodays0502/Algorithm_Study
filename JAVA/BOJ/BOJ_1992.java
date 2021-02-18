package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int N;
	static int input[][];
	static StringBuilder sb = new StringBuilder();

	static void dfs(int n ,int y , int x) {
		if(n == 1) {sb.append(input[y][x]);}
		else {
			int standard = input[y][x];
			boolean flag = true;	
			for(int i = y ; i < y + n ; i++) {
				for(int j = x ; j < x + n; j++) {
					if(standard != input[i][j]) {
						flag = false;
					}
				}
			}
			if(flag) {
				sb.append(input[y][x]);
			}else {
				sb.append('(');
				dfs(n/2 ,y , x);
				dfs(n/2 ,y , x + n/2);
				dfs(n/2 ,y + n/2 , x);
				dfs(n/2 ,y + n/2, x + n/2);
				sb.append(')');
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			for (int j = 0; j < N; j++) {
				input[i][j] = command.charAt(j)-'0';
			}
		}
		dfs(N,0,0);
		System.out.println(sb.toString());
	}

}
