import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class SWea_1767 {
	static int n;
	static int input[][];
	static int result = 0;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static List<int[]> core; 
	static int maxCore;
	static void dfs(int cnt,int length,int coreCount) {
	//	System.out.println(cnt+" "+core.size());
		if(cnt == core.size()) {
			if(coreCount > maxCore) {maxCore = coreCount; result = length;}
			else if(coreCount == maxCore) {result = Math.min(result, length);}
		}else {
			int y = core.get(cnt)[0];
			int x = core.get(cnt)[1];
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				boolean find = false;
				int count = 0;
				while(ny >= 0 && ny <= n-1 && nx >= 0 && nx <= n-1) {
					if(input[ny][nx] == 1 || input[ny][nx] ==2) {find = true; break;}
					count++;
					ny += dy[i];
					nx += dx[i];
				}
				if(!find) {
					ny = y + dy[i];
					nx = x + dx[i];
					while(ny >= 0 && ny <= n-1 && nx >= 0 && nx <= n-1) {
						input[ny][nx] = 2;
						ny += dy[i];
						nx += dx[i];
					}
				}
				if(!find && maxCore <= coreCount + core.size() - cnt) {dfs(cnt+1,length + count,coreCount+1);}
				if(!find) {
					ny = y + dy[i];
					nx = x + dx[i];
					while(ny >= 0 && ny <= n-1 && nx >= 0 && nx <= n-1) {
						input[ny][nx] = 0;
						ny += dy[i];
						nx += dx[i];
					}
				}
				if(find && maxCore <= coreCount + core.size() - cnt-1) {dfs(cnt+1,length ,coreCount);}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			result = Integer.MAX_VALUE;
			maxCore = 0;
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			input = new int[n][n];
			core = new LinkedList<int[]>();
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					if(input[i][j] == 1) core.add(new int[] {i,j});
				}
			}
			dfs(0,0,0);
			System.out.println("#"+t+" "+result);
		}
	}

}
