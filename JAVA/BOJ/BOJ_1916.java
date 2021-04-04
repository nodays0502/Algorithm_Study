package dij;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1916 {
	static int start , end;
	static int n, m ;
	static int map[][];
	static final int LIMIT = 987654321;
	static int dij() {
		int distance[];
		boolean visited[];
		visited = new boolean[n];
		distance = new int[n];
		int result = -1;
		for(int i = 0 ; i < n ; i++) {
			distance[i] = LIMIT;
		}
		distance[start] = 0;
		for(int i = 1 ; i < n ; i++) {
			int min = LIMIT;
			int minIndex = 0;
			for(int j = 1 ; j < n ; j++) {
				if(!visited[j] && min > distance[j]) {
					minIndex = j;
					min = distance[j];
				}
			}
//			System.out.println(minIndex);
//			System.out.println(Arrays.toString(distance));
			visited[minIndex] = true;
			if(minIndex == end) {result = min; break;}
			for(int j = 1; j < n ; j++ ) {
				if(!visited[j] && distance[j] > map[minIndex][j] + min) {
					distance[j] = map[minIndex][j] + min;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken())+1;
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = LIMIT;
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(w, map[a][b]);
		}
		st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(dij());
	}
}
