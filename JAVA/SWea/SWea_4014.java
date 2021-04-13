import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_4014 {
	static int N , X;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T  = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j  = 0 ; j  < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0 ;
			for(int i = 0 ; i < N ; i++) {
				boolean flag = true;
				int now = map[i][0];
				int cnt = 1;
				boolean check = false;
				for(int j  = 1 ; j  < N ; j++) {
					if(now == map[i][j]) {
						cnt++;
						if(check && cnt == X) {
							check = false;
							cnt = 0;
						}
					}else if(now+1 == map[i][j]) {
						if(cnt < X) {
							flag = false;
							break;
						}
						cnt = 1;
						now = map[i][j];
						check = false;
					}else if(now-1 == map[i][j]){ // 작다면
						if(check && cnt < X) {
							flag = false;
							break;
						}
						now = map[i][j];
						cnt = 1;
						check = true;
					}else {
						flag = false; 
						break;
					}
				}
				if(check) {
					if(cnt < X) flag = false;
				}
				if(flag) result++;
				
				
				
				flag = true;
				now = map[0][i];
				cnt = 1;
				check = false;
				for(int j  = 1 ; j  < N ; j++) {
					if(now == map[j][i]) {
						cnt++;
						if(check && cnt == X) {
							check = false;
							cnt = 0;
						}
					}else if(now+1 == map[j][i]) {
						if(cnt < X) {
							flag = false;
							break;
						}
						cnt = 1;
						now = map[j][i];
						check = false;
					}else if(now-1 == map[j][i]){ // 작다면
						if(check && cnt < X) {
							flag = false;
							break;
						}
						now = map[j][i];
						cnt = 1;
						check = true;
					}else {
						flag = false; 
						break;
					}
				}
				if(check) {
					if(cnt < X) flag = false;
				}
				if(flag) {result++;}

				
				
				
				
			}
			System.out.printf("#%d %d%n",t,result);
		}
	}

}
