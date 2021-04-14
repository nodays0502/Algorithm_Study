package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWea_5656 {
	static int n,m,k;
	static int map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int result = Integer.MAX_VALUE;
	static void gravity(int[][] arr) {
		for(int j  = 0 ; j< m ; j++) {
			Queue<Integer> q = new LinkedList<>();
			for(int i = n-1 ; i >= 0 ; i--) {
				if(arr[i][j] != 0) {
					q.offer(arr[i][j]);
					arr[i][j] = 0;
				}
			}
			for(int i = n-1 ; i >= 0 ; i--) {
				if(!q.isEmpty()) {
					arr[i][j] = q.poll();
				}else {
					break;
				}
			}
		}
	}
	static void counting(int[][]arr) {
		int cnt = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				if(arr[i][j] != 0) {
					cnt++;
				}
			}
		}
		result = Math.min(result, cnt);
	}
	static void dfs(int depth,int[][] arr) {
		if(depth == k) {
			counting(arr);
			return ;
		}
		boolean find = false;
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n; j++) {
				if(arr[j][i] != 0) {
					find = true;
					int[][] temp = makeTemp(arr);
					pung(j,i,temp);
					gravity(temp);
					dfs(depth+1,temp);
					break;
				}
			}
		}
		if(!find) 
			counting(arr);
	}
	private static void pung(int y, int x, int[][] temp) {
		if(map[y][x] == 0) return;
		int length = temp[y][x];
		temp[y][x] = 0;
		for(int i = 0 ; i < 4; i++) {
			int ny = y;
			int nx = x;
			for(int j = 1; j < length ; j++) {
				ny += dy[i];
				nx += dx[i];
				if(nx >= 0 && nx < m && ny >=0 && ny < n)
					pung(ny,nx,temp);
				else 
					continue;
			}
		}
		
	}
	static int[][] makeTemp(int[][] arr){
		int[][] temp = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t= 1; t <= T ; t++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			k = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < m ; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,map);
			System.out.printf("#%d %d%n",t,result);
		}
	}

}
