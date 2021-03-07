package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE , n;
	static int input[][];
	static int divide[][];
	static int answer =  1;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static void makesafyzone(int height) {
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++) {
				if(input[i][j] <= height) {
					divide[i][j] = -1;
				}else {
					divide[i][j] = 0;
				}
			}
		}
	}
	static int dfs(int y ,int x) {
		if(divide[y][x] == -1) return 0;
		else {
			divide[y][x] = -1;
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && divide[ny][nx] != -1) {
					dfs(ny,nx);
				}
			}
			return 1;
		}
	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(divide[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n][n];
		divide = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, input[i][j]);
				max = Math.max(max, input[i][j]);
			}
		}
		for(int t = min ; t < max ; t++) {
			makesafyzone(t);
			int result = 0 ;			
	//		print();
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					result += dfs(i,j);
				}
			}
			answer = Math.max(answer, result);
			if(answer == 9) {System.out.println(t);}
		}
		System.out.println(answer);
	}
}
