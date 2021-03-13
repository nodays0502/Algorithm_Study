package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_4008 {
	static int n ; 
	static int input[];
	static int oper[] = new int[4]; // '+' '-' '*' '/'
	static int resultMax = Integer.MIN_VALUE ;
	static int resultMin = Integer.MAX_VALUE ;
	static void perm(int depth,int result) {
		if(depth == n) {
	//		System.out.println(result);
			resultMax = Math.max(result, resultMax);
			resultMin = Math.min(result, resultMin);
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				if(oper[i] > 0) {
					oper[i]--;
					switch(i) {
						case 0 : perm(depth + 1 , result + input[depth] ); break;
						case 1 : perm(depth + 1 , result - input[depth] ); break;
						case 2 : perm(depth + 1 , result * input[depth] ); break;
						case 3 : perm(depth + 1 , result / input[depth] ); break;
					}
					oper[i]++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			resultMax = Integer.MIN_VALUE; 
			resultMin = Integer.MAX_VALUE; 
			
			st = new StringTokenizer(br.readLine()," "); 
			n = Integer.parseInt(st.nextToken());		
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < 4 ; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			input = new int[n];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < n ; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(1 , input[0]);
	//		System.out.println(resultMax + " " +resultMin);
			System.out.println("#"+t+" "+(resultMax - resultMin));
		}
	}
}
