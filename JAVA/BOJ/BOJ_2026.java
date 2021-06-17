package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2026 {
	static int k , n , f;
	static boolean map[][];
	static int choice[];
	static boolean finish = false;
	static void dfs(int depth , int start) {
	//	System.out.println(depth);
		if(finish) return ;
		if(depth == k) {		
			for(int i = 0 ; i < k ; i++) {
				System.out.println(choice[i]);
			}
			finish = true;
		}else {
			for(int i = start ; i <= n ; i++) {
					boolean flag = true;
					for(int j = 0 ; j < depth; j++) {
						if(!map[choice[j]][i]) {
							flag = false;
							break;
						}
					}
			//		System.out.println(flag);
					if(flag) {
						choice[depth] = i;
						dfs(depth+1, i+1);
					}
				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		map = new boolean[n+1][n+1];
		choice = new int[k];
		for(int i = 0 ; i < f; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		dfs(0,1);
		if(!finish) {System.out.println(-1); return ;}
		
	}
}
