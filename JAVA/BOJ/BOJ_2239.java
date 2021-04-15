package Lecture0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239 {
	static int n = 9 ;
	static int map[][] = new int[n][n];
	static boolean find = false;
	static void dfs(int y , int x) {
		if(find) return; // 하나라도 찾았다면
		if(y == n && x == 0) { // 끝까지 도착한다면,
			find = true; // 찾음
			print();
			return ;
		}else {
	//		print();
	//		System.out.println();
			int ny = y;
			int nx = x;
			if(++nx >= n) {
				nx = 0;
				ny++;
			}
			if(map[y][x] == 0) {
				boolean num[] = new boolean[10];
				for(int i = 0 ; i < n ; i++) {
					num[map[y][i]]  = true;
					num[map[i][x]]  = true;
				}
				for(int i = 3 * (y/3) ; i < 3 * (y/3)  +3; i++) {
					for(int j = 3 * (x/3) ; j < 3 * (x/3) + 3; j++) {
						num[map[i][j]]  = true;
					}
				}
				for(int i = 1 ; i <= n ; i++) {
					if(!num[i]) {
						map[y][x] = i;
						dfs(ny,nx);
						map[y][x] = 0 ;
					}
				}
			}else {
				dfs(ny,nx);
			}
		}
	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = command.charAt(j) - '0';
			}
		}
		dfs(0,0);
	}

}
