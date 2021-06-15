package dij;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18352 {
	static int n,m,k,x;
	static List<Integer> result = new ArrayList<>();
	static List<Integer> map[];
	static void dij() {
		int distance [] = new int[n+1];
		Arrays.fill(distance,987654321);
		boolean visited[] = new boolean[n+1];
		distance[x] = 0;
		for(int i = 1 ; i <= n ; i++) {
			int min = 987654321;
			int minIndex = 1;
			for(int j = 1 ; j <= n ; j++) {
				if(!visited[j] && min > distance[j]) {
					minIndex = j;
					min = distance[j];
				}
			}
			visited[minIndex] = true;
			if(min == k) {
				result.add(minIndex);
			}
			else if(min > k) {
				break;
			}
//			System.out.println("minINdex:"+minIndex);
			for(int j = 0 ; j < map[minIndex].size() ; j++) {
				int nowIndex = map[minIndex].get(j);
//				System.out.println(nowIndex);
				if(!visited[nowIndex] && min + 1 < distance[nowIndex]) {
					distance[nowIndex] = min + 1;
				}
			}
//			System.out.println(Arrays.toString(distance));
		}
		Collections.sort(result);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new List[n+1];
		for(int i = 1; i <= n ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
		}
		dij();
		if(result.size() == 0) {
			System.out.println(-1);
		}
		for(int i = 0 ; i < result.size();i++) {
			System.out.println(result.get(i));
		}
	}
}
