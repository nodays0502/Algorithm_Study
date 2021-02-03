import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3085 {
	static char [][] map;

	static int n ;
	static int answer = 0;
	/*static void check() {
		for(int i = 0; i < n; i++) { // 행 고정
			int cnt = 1;
			for(int j = 0 ; j < n-1 ; j++) {
				if(map[i][j] == map[i][j+1]) { // 가로 판단
					cnt++;
				}else {
					cnt =1;
				}
				answer = Math.max(cnt, answer);
			}

		}
		for(int i = 0; i < n; i++) { // 열 고정
			int cnt = 1;
			for(int j = 0; j < n - 1 ; j++) {
				if(map[j][i] == map[j+1][i]) { // 세로 판단
					cnt++;
				}else {
					cnt = 1;
				}
				answer = Math.max(cnt, answer);
			}

		}
	}*/
	static void check() {
	for(int i = 0; i < n; i++) { // 
		int cnt = 1;
		for(int j = 0 ; j < n-1 ; j++) {
			if(map[i][j] == map[i][j+1]) { // 행 고정하고 가로 판단
				cnt++;
			}else {
				cnt =1;
			}
			answer = Math.max(cnt, answer);
		}
		cnt = 1;
		for(int j = 0; j < n - 1 ; j++) {
			if(map[j][i] == map[j+1][i]) { // 열을 고정하고 세로 판단
				cnt++;
			}else {
				cnt = 1;
			}
				answer = Math.max(cnt, answer);
		}
	}

}

	static void swap(int y,int x ,int cy, int cx) {
		char temp = map[cy][cx];
		map[cy][cx] = map[y][x];
		map[y][x] = temp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];

		for(int i = 0 ; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(j != n-1 && map[i][j] != map[i][j+1]) { // J+1이 n-1을 넘지 않아야한다.
					swap(i,j,i,j+1);
					check();
					swap(i,j,i,j+1);
				}
				if( i != n-1 && map[i][j] != map[i+1][j]) { // i+1이 n-1이 넘지 않아야한다.
					swap(i,j,i+1,j);
					check();
					swap(i,j,i+1,j);
				}
			}
		}
		System.out.println(answer);
	}
}

