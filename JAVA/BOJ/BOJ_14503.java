package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int n , m ;
	static int input [][]; // 0 청소 안된 곳 1 벽 2 청소 한 곳
	static int dy[] = {-1,0,1,0}; // 0 북 1 동 2 남 3 서
	static int dx[] = {0,-1,0,1};
	static int y , x, dir;
	static int result = 0 ;
	static void moving() {
		if(input[y][x] == 0) { // 1
			input[y][x] = 2 + result;
			result++;
		}
		boolean flag = true;
		for(int i = 0 ; i < 4; i++) { // c , d 조건 확인
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(input[ny][nx] == 0) flag = false;
		}
		if(flag) { // c,d
			int i = dir; // 현재 방향의 후진
			int ny = y - dy[i];
			int nx = x - dx[i];
			if(input[ny][nx] == 1) return; // d
			else { y = ny; x = nx;} //c
		}else { // a, b
			int i = dir + 1; // 왼쪽 방향
			if(i >= 4) i -= 4;
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(input[ny][nx] == 0) {dir = i ; y = ny; x = nx;}
			else {dir = i;}
		}
		moving();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		if(dir == 1) {dir = 3;}
		else if (dir == 3) {dir = 1;}
		input = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		moving();
		System.out.println(result);
	}
}
