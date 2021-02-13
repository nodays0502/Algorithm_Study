package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int N,M,K;
	static int answer = Integer.MAX_VALUE;
	static int[][] input; 
	static int[] r,c,s;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static boolean isSelected[];
	static void rotation(int nr, int nc, int ns) {
		for(int i = 0 ; i < ns ; i++) {
			int temp = input[nr-ns + i][nc-ns + i];
			int y = nr-ns + i;
			int x = nc-ns + i;
			for(int j = 0 ; j < 4 ; j++) {
				while(true) {
					int nx = x + dx[j];
					int ny = y + dy[j]; 
					if (nx < nc - ns + i || nx > nc + ns - i || ny < nr - ns + i || ny > nr + ns - i) break;
					input[y][x] = input[ny][nx];
					x = nx;
					y = ny;
				}
			}
			input[nr-ns + i][nc-ns + i + 1] = temp;
		}
	}
	static void perm(int cnt) {
		if(cnt == K) {
			answer = Math.min(answer, cal());
		}
		else {
			int [][] save;
			save = new int[N][M];
			for(int i =0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					save[i][j] = input[i][j];
				}
			}
			for(int i = 0 ; i < K ; i++) {
				if(!isSelected[i]) {
					for(int k =0 ; k < N; k++) {
						for(int j = 0 ; j < M; j++) {
							input[k][j] = save[k][j];
						}
					}
					isSelected[i] = true;
					rotation(r[i],c[i],s[i]);
					perm(cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
	static int cal() {
		int result = Integer.MAX_VALUE ;
		for(int i = 0 ; i < N; i++) {
			int sum = 0 ;
			for(int j = 0 ; j < M ; j++) {
				sum += input[i][j];
			}
			result = Math.min(sum, result);
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				input[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		r = new int[K];
		c = new int[K];
		s = new int[K];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			r[i] = Integer.parseInt(st.nextToken())-1;
			c[i] = Integer.parseInt(st.nextToken())-1;
			s[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[K];
		perm(0);
		System.out.println(answer);
	}
}

