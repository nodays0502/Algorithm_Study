package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
	static int n;
	static boolean visited[] = new boolean[10];
	static char choice[];
	static char input[];
	static String min = "99999999999999";
	static String max = "00000000000000";
	static void dfs(int depth) {
//		System.out.println(depth);
//		System.out.println(Arrays.toString(visited));
		if(depth == n) {
			String temp = new String(choice);
//			System.out.println(temp);
//			System.out.println(min.compareTo(temp));
			if(max == "00000000000000") {
				min = temp;
				max = temp;
			}
			if(min.compareTo(temp) > 0) {
				min = temp;
			}
			if(max.compareTo(temp) < 0) {
				max = temp;
			}
		}else {
	//		System.out.println("asd");
			if(input[depth] == '<') {
		//		System.out.println(Integer.parseInt(choice[depth]+""));
				for(int i = choice[depth] - '0' ; i < 10 ; i++) {
					if(!visited[i]) {
						visited[i] = true;
						choice[depth+1] = (char)(i+'0');
						dfs(depth + 1);
						visited[i] = false;
					}
				}
			}else {
				for(int i = 0 ; i < choice[depth] - '0' ; i++) {
					if(!visited[i]) {
						visited[i] = true;
						choice[depth+1] = (char)(i+'0');
						dfs(depth + 1);
						visited[i] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine()," ");
		input = new char[n];
		for(int i = 0 ; i < n; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		choice = new char[n + 1];
//		System.out.println(Arrays.toString(input));
		for(int i = 0 ; i < 10 ; i++) {
			visited[i] = true;
			choice[0] = (char)(i+'0');
			dfs(0);
			visited[i] = false;
		}
		System.out.println(max);
		System.out.println(min);
	}
}
