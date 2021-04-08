package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20437 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++ ) {
			ArrayList<Integer>[] alpha; 
			alpha = new ArrayList[26];
			for(int i = 0 ; i < 26 ; i++) {
				alpha[i] = new ArrayList<>();
			}
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int size = W.length();
			for(int i = 0 ; i < size; i++) {
				alpha[W.charAt(i)-'a'].add(i);
			}
			int no3 = Integer.MAX_VALUE, no4 = -1;
			for(int i = 0 ; i < 26; i++) {
				int length = alpha[i].size();
				if(alpha[i].size() >= K) {
					for(int j = 0 ; j+K-1 < alpha[i].size() ; j++) {
						no3 = Math.min(no3, alpha[i].get(j+K-1) - alpha[i].get(j)+1);
						no4 = Math.max(no4, alpha[i].get(j+K-1) - alpha[i].get(j)+1);
					}
				}
			}

			if(no3 != Integer.MAX_VALUE && no4 != -1) {
				System.out.println(no3+" "+no4);
			}else {
				System.out.println(-1);
			}
		}
	}
}
