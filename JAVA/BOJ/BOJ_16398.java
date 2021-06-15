package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16398 {
	static int n;
	static int map[][];
	static long prim() {
		long result= 0 ;
		int distance[] = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0]= 0;
		boolean visited[] = new boolean[n];
		for(int i = 0 ; i < n ; i++) {

			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0 ; j < n; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minIndex = j;
				}

			}
			result += min;
			visited[minIndex] = true;
			for(int j = 0 ; j < n; j++) {
				if(!visited[j] && map[minIndex][j] < distance[j]) {
					distance[j] = map[minIndex][j];
				}
			}

		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(prim());
	}
}
