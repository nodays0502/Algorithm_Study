package Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684 {
	static int N ,M;
	static int T;
	static int input[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int limit = 0;
	static int count = 1 ;
	static int cal() {
		int result = -1;
		for(int i = 0; i <= 3 ; i++) {
			limit = i;
			if(comb(0, M * 1 + 1)) {result = i;break;}
		}
		return result;
	}
	static boolean comb(int cnt , int start) {
		if(cnt == limit) {
			boolean finish = true;
			for(int i = 1 ; i <= M; i++) {
				if(!go(i)) {finish = false; break;}
			}
			return finish;
		}else {
			boolean find = false;
			for(int i = start / M ; i <= N ; i++) {
				if (i == start / M) {
					for (int j = start % M; j < M; j++) {
						if(input[i][j] == 0 && input[i][j + 1] == 0) {
							input[i][j] = count;
							input[i][j + 1] = count;
							count++;
							find = comb(cnt + 1, M * i + j + 1);
							input[i][j] = 0;
							input[i][j + 1] = 0;
							count--;
						}
						if (find)	break;
					}
				}else {
					for(int j = 1; j < M ; j++) {
						if(input[i][j] == 0 && input[i][j+1] == 0) {
							input[i][j] = count;
							input[i][j+1] = count;
							count++;
							find = comb(cnt + 1 , M * i + j + 1);
							input[i][j] = 0;
							input[i][j+1] = 0;
							count--;
						}
						if(find) break;
					}
					
				}
				if(find) break;
			}
			return find;
		}
	}
	static boolean go(int start) {
		int y = 0 ;
		int x = start;
		while(y <= N) {
			if(input[y][x] != 0) {
				if(x < M && input[y][x+1] == input[y][x]) {x= x+1;}
				else {x = x - 1;}
			}
			y++;
		}
//		System.out.println(x+" "+start);
		return x==start? true:false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		input = new int[N+1][M+1];
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[a][b] = count;
			input[a][b+1] = count;
			count++;
		}

		System.out.println(cal());
	}
}
