import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15663 {
	static int n;
	static int m;
	static StringBuffer sb = new StringBuffer();
	static int[] choice;
	static boolean[] check; // 몇번 나왔는지 카운팅해봐라
	static int[] num;
	static boolean[] use = new boolean[10001];
	static void perm(int nm) {
		if(nm == m) {
			for(int i = 0 ;i<nm;i++) {
				sb.append(choice[i]+" ");
			}
			sb.append('\n');
			return;
		}
		/*List<Integer> use = new LinkedList<>();
		for(int i = 0; i< n;i++) {
			if(check[i] == false && (!use.contains(num[i]))) {
				check[i] = true;
				use.add(num[i]);
				choice[nm] = num[i];
				perm(nm+1);
				check[i] = false;
			}
		}*/
		for(int i = 0; i< n;i++) {
			if(check[i] == false) {
				check[i] = true;
				choice[nm] = num[i];
				int temp = num[i];
				perm(nm+1);
				check[i] = false;
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
	//	System.out.println(Arrays.toString(num));
		perm(0);
		System.out.println(sb.toString());
	}
}
