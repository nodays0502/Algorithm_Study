import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15664 {
	static int n;
	static int m;
	static StringBuffer sb = new StringBuffer();
	static int[] choice;
	static boolean[] check; // 몇번 나왔는지 카운팅해봐라
	static int[] num;
	static boolean[] use = new boolean[10001];
	static void perm(int nm,int start) {
		if(nm == m) {
			for(int i = 0 ;i<nm;i++) {
				sb.append(choice[i]+" ");
			}
			sb.append('\n');
			return;
		}
		for(int i = start; i< n;i++) {
			int temp = num[i];
			choice[nm] = num[i];
			perm(nm+1,i+1);
			while(true) {
				if(i >= n || temp != num[i]) {
					break;
				}else {
					i++;
				}
			}
			i--;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		choice = new int[m];
		check = new boolean[n];
		num = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		for(int i = 0;i<n;i++) {
			
		}
	//	System.out.println(Arrays.toString(num));
		perm(0,0);
		System.out.println(sb.toString());
	}
}
