package Lecture0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int N;
	static int people[];
	static int map[][];
	static boolean choose[];
	static boolean check[];
	static int result = Integer.MAX_VALUE;
	static void pset(int depth ) {
		if(depth == N) {
			checking();
			return ;
		}else {
			choose[depth] = false;
			pset(depth+1);
			choose[depth] = true;
			pset(depth+1);
		}
	}
	static void checking() {
		check = new boolean[N];
		boolean t = false;
		boolean f = false;
		int sum[] = new int[2];
		for(int i = 0 ; i < N ; i++) {
			if(!t && choose[i] == true) {
				t = true;
				sum[0] = dfs(i,true);
			}else if(!f && choose[i] == false) {
				f = true;
				sum[1] = dfs(i,false);
			}
		}
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) return;
		}
	//	System.out.println(sum[0]+" "+sum[1]);
		result = Math.min(result, Math.abs(sum[0]-sum[1]));
	}
	static int dfs(int now , boolean flag) {
		int sum = 0 ;
		check[now] = true;
		sum += people[now];
		for(int i = 0 ; i < N ; i++) {
			if(map[now][i] == 1 && choose[i] == flag && !check[i]) {
				sum += dfs(i,flag);
			}
		}
		return sum;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		map = new int[N][N];
		people = new int[N];
		choose = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < count ; j++) {
				int node = Integer.parseInt(st.nextToken())-1;
				map[i][node] = 1;
				map[node][i] = 1;
			}
		}
		pset(0);
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
		
	}

}
