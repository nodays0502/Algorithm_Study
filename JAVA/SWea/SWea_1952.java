package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_1952 {
	static int pay[] = new int[4];// 1일 1달 3달 12달
	static int monthpay[] = new int[12];
	static int result = 0 ;
	static void dfs(int month , int money) {
		if(money >= result) return ;
		if(month >= 12) {
			result = Math.min(result, money);
		}else {
			if(monthpay[month] == 0) dfs(month+1 , money);
			else {
				dfs(month + 1 , money + monthpay[month] * pay[0]);
				dfs(month + 1 , money + pay[1]);
				dfs(month + 3 , money + pay[2]);				
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t  = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ;i < 4; i++) {
				pay[i] = Integer.parseInt(st.nextToken());
			}
			result = pay[3];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < 12; i++) {
				monthpay[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			System.out.println("#"+t+" "+result );
		}
	}
}
