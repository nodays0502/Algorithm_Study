package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1504_2 {
	static int N , E;
	static int map[][];
	static final int INF = 98765432;
	static int target[] = new int[2];
	static int dij(int start , int end) {
		int result = Integer.MAX_VALUE;
		int distance[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		for(int i = 1 ; i <= N ; i++) {
			distance[i] = INF;
		}
		distance[start] = 0;
		for(int  i = 1 ;  i <= N ; i++) {
			int min = INF;
			int minIndex = 0;
			for(int j  = 1; j <= N ; j++) {
				if(!visited[j] && min > distance[j]) {
					minIndex = j ; 
					min = distance[j];
				}
			}
			visited[minIndex] = true;
			if(minIndex == end) {result = min; break;}
			for(int j  = 1; j <= N ; j++) {
				if(!visited[j] && distance[j] > min + map[minIndex][j]) {
					distance[j] = min + map[minIndex][j];
				}
			}
				
		
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(i != j) {
					map[i][j] = INF;			
				}
			}
		}
		for(int i = 0 ;i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(c, map[a][b]);
			map[b][a] = Math.min(c, map[b][a]);
		}
		st = new StringTokenizer(br.readLine()," ");
		target[0] = Integer.parseInt(st.nextToken());
		target[1] = Integer.parseInt(st.nextToken());
		

		int result1 = 0;
		result1 += dij(1,target[0]);
		result1 += dij(target[0],target[1]);
		result1 += dij(target[1],N);
		
		int result2 = 0;
		result2 += dij(1,target[1]);
		result2 += dij(target[1],target[0]);
		result2 += dij(target[0],N);
//		System.out.println(result1+" "+result2);
		int result = Math.min(result1, result2);
		if(result >= INF) result = -1;
		System.out.println(result);
	}
}
