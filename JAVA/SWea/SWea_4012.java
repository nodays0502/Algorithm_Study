package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_4012 {
	static int result = Integer.MAX_VALUE ;
	static int n;
	static int input[][];
	static boolean choice[];
	static void comb(int depth , int start) {
		if(depth == n/2) {
			int sum[] = new int[2];
			for(int i = 0 ; i < n ; i++) {
				for(int j  = i+1 ; j < n ; j++) {
					if(choice[i] == true && choice[j] == true) {
						sum[0] += input[i][j]+input[j][i];
					}else if(choice[i] == false && choice[j] == false){
						sum[1] += input[i][j]+input[j][i];
					}
				}
			}
			result = Math.min(result,Math.abs(sum[0]-sum[1]));
		}else {
			for(int i = start ; i < n ; i++) {
				choice[i] = true;
				comb(depth+1 , i+1);
				choice[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			result = Integer.MAX_VALUE ;
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			input= new int[n][n];
			choice = new boolean[n];
			for(int i = 0 ; i < n ; i++){
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			System.out.println("#"+t+" "+result);
		}
	}
}
