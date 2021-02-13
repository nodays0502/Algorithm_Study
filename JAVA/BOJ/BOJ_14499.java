package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499 {
	static int dice[][] = new int[4][3]; // 밑 부분 : [1][1]
	static int N,M,K;
	static int sy,sx;
	static int input[][];
	static int dy[] = {0,0,0,-1,1}; // 
	static int dx[] = {0,1,-1,0,0}; // 
	static void moving(int dir) {
		int ny = sy + dy[dir];
		int nx = sx + dx[dir];
		if(nx >= 0 && nx < M && ny >=0 && ny < N) {
			sy = ny;
			sx = nx;
		}else {
			return;
		}
//		System.out.println(sy+" "+sx);
		switch(dir) {
		case 1 : 
			int temp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
			break;
		case 2 :
			temp = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = temp;
		
			break;
		case 3 :
		case 4 :
			temp = dice[1][1];
			int y = 1;
			int x = 1;
			for(int i = 0 ; i < 3 ; i++) {
				ny = y + dy[dir];
				if(ny < 0 ) ny = 3;
				else if(ny >= 4) ny = 0;
				dice[y][x] = dice[ny][x];
				y = ny;
			}
			dice[1-dy[dir]][1] = temp;
			break;
		}
		if(input[sy][sx] == 0) {
			input[sy][sx] = dice[1][1];
		}else {
			dice[1][1] = input[sy][sx];
			input[sy][sx] = 0;
		}
	//	System.out.println(Arrays.deepToString(dice));
		System.out.println(dice[3][1]);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < K ; i++) {
			int temp = Integer.parseInt(st.nextToken());
	//		System.out.print(temp+" ");
			moving(temp);
	//		System.out.println(Arrays.deepToString(dice));
		}
	}
}
