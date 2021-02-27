package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2116 {
	static int n ; 
	static int input[][];
	static boolean notside[][];
	static int result = 0;
	static void dfs(int cnt,int upnum){
		if(cnt == n) {
			int sum = 0;
			for(int i = 0 ; i < n ; i++) {
				int max = 0 ;
				for(int j = 0 ; j < 6 ; j++) {
					if(!notside[i][j]) {
						max = Math.max(max, input[i][j]);
					}
				}
				sum += max;
			}
			result = Math.max(sum,result);
		}else if(cnt == 0) {
			for (int i = 0; i < 6; i++) {
				notside[cnt][i] = true;
				notside[cnt][map.get(i)] = true;
				dfs(cnt + 1, input[cnt][map.get(i)]);
				notside[cnt][i] = false;
				notside[cnt][map.get(i)] = false;
			}
		}
		else {
			for(int i = 0 ; i < 6; i++) {
				if(input[cnt][i] == upnum) {
					notside[cnt][i] = true;
					notside[cnt][map.get(i)] = true;
					dfs(cnt + 1, input[cnt][map.get(i)]);
					notside[cnt][i] = false;
					notside[cnt][map.get(i)] = false;
				}
			}
		}
	}
	static HashMap<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		map.put(0,5);
		map.put(1,3);
		map.put(2,4);
		map.put(5,0);
		map.put(3,1);
		map.put(4,2);
		input = new int[n][6];
		notside = new boolean[n][6];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < 6 ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(result);
	}

}
