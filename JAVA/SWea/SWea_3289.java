package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_3289 {
	static int n , m;
	static int parent[];
	static StringBuilder sb = new StringBuilder();
	static int findParent(int index) { // findSet()
	//	System.out.println(Arrays.toString(parent));
		if(index == parent[index]) return index;
		else return parent[index] = findParent(parent[index]);
	}
	static void union(int a, int b) { // union
		int parentA = findParent(a);
		int parentB = findParent(b);
		if(parentA == parentB) ;
		else {
			parent[parentB] = parentA;
		}
	}
	static void exec(int command , int a , int b) {
		if(command == 0) {
			union(a,b);
		}else if(command == 1) {
			int parentA = findParent(a);
			int parentB = findParent(b);
	//		System.out.println(parentA +" "+parentB);
	//		if(parentA == parentB) {System.out.print("1");}
	//		else {System.out.print("0");}
			if(parentA == parentB) {sb.append("1");}
			else {sb.append("0");}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			for(int i = 0 ; i <= n ; i++) { // make()
				parent[i] = i;
			}
			//System.out.print("#"+t+" ");
			sb.append("#"+t+" ");
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				exec(command,a,b);				
			}
			sb.append("\n");
			System.out.println();
		}
		System.out.println(sb.toString());
	}

}
