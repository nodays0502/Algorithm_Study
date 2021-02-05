import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952 {
	static int n ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		Stack<int[]> s = new Stack<>();
		int result = 0;
		for(int i = 0 ; i < n ; i++) {
			int nowgrade = 0;
			int nowneedTime = 0;
			st = new StringTokenizer(br.readLine()," ");
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0) {
				if(!s.isEmpty()) {
					nowgrade = s.peek()[0];
					nowneedTime = s.pop()[1];
				}
			}else {
				nowgrade = Integer.parseInt(st.nextToken());
				nowneedTime = Integer.parseInt(st.nextToken());
			}
			if(--nowneedTime == 0) {
				result += nowgrade;
			}else {
				s.push(new int[] {nowgrade,nowneedTime});
			}
		}
		System.out.println(result);
	}
}
