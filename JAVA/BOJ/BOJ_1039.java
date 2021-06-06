package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1039 {
	static String N;
	static int k;
	static int now[];
	static boolean visited[][];
	static int result = -1;
	static void swap(int a, int b) {
		int temp = now[a];
		now[a] = now[b];
		now[b] = temp;
	}
	static void dfs(int depth) {
	//	System.out.println(Arrays.toString(now));
		if(depth == k) {
			int temp = 0 ;
			for(int i = 0 ; i < now.length ; i++) {
				temp*=10;
				temp += now[i];
			}
			result = Math.max(result,temp);
		}else {
			for(int i = 0 ; i < now.length; i++) {
				for(int j = i+1 ; j < now.length; j++) {
					if( i == 0 && now[j] == 0) continue;
					swap(i,j);
					int temp = 0 ;
					for(int l = 0 ; l < now.length ; l++) {
						temp*=10;
						temp += now[l];
					}
					if(!visited[temp][depth]) {
						visited[temp][depth] = true;
						dfs(depth+1);						
					}
					swap(i,j);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		k = Integer.parseInt(st.nextToken());
		now = new int[N.length()];
		visited = new boolean[1000001][k];
		for(int i = 0 ; i < N.length(); i++) {
			now[i] = N.charAt(i) - '0';
		}
		dfs(0);
		System.out.println(result);
	}
}
