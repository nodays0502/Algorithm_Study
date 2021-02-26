package Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int N , M;
	static int map[][];
	static int zeroCount = 0;
	static int result = 0; // 시시티비 영역
	static List<int[]> list = new LinkedList<>();
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};
	static void dfs(int cnt, int sum) {
		if(cnt == list.size()) {
			result = Math.max(result, sum);
		}else {
			int y =list.get(cnt)[0];
			int x = list.get(cnt)[1];
			List<int[]> move = new LinkedList<>();
			switch (map[y][x]) {
			case 1: // 1번 경우
				move.add(new int[] {0});
				move.add(new int[] {1});
				move.add(new int[] {2});
				move.add(new int[] {3});
				break;
			case 2: // 2번 경우
				move.add(new int[] {0,2});
				move.add(new int[] {1,3}); 
				break;
			case 3: // 3번 경우
				move.add(new int[] {0,1}); 
				move.add(new int[] {1,2}); 
				move.add(new int[] {2,3}); 
				move.add(new int[] {3,0}); 
				break;
			case 4: // 4번 경우
				move.add(new int[] {0,1,2}); 
				move.add(new int[] {1,2,3}); 
				move.add(new int[] {2,3,0}); 
				move.add(new int[] {3,0,1}); 
				break;
			case 5: // 5번 경우
				move.add(new int[] {0,1,2,3}); 
				break;
			}
			int count = 0;
			for(int i = 0 ; i < move.size() ; i++) {
				count = 0;
				for(int j = 0 ; j < move.get(i).length;j++) {
					int dir = move.get(i)[j];
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					while(true) {
						if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 6) {
							if(map[ny][nx] == 0 ) {map[ny][nx] = 7+cnt; count++;}
						}else {
							break;
						}
						ny += dy[dir];
						nx += dx[dir];
					}
				}
				dfs(cnt+1,sum+count);
				for(int j = 0 ; j < move.get(i).length;j++) {
					int dir = move.get(i)[j];
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					while(true) {
						if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 6) {
							if(map[ny][nx] == 7 +cnt) {map[ny][nx] = 0;}
						}else {
							break;
						}
						ny += dy[dir];
						nx += dx[dir];
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) list.add(new int[] {i,j});
				else if(map[i][j] ==0) zeroCount++;
			}
		}
		dfs(0,0);
	//	System.out.println(zeroCount + " " + result);
		System.out.println(zeroCount - result);
		
	}
}
