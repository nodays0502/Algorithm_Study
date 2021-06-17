package dij;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int end;
	int weight;
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}
}
public class BOJ_10282 {
	static int n,d,c;
	static List<Node> input[];
	static int[] dij() {
		int[] result = {0,0}; // 0 : 감염 개수 , 1 : 시간
		boolean visited[] = new boolean[n+1];
		int distance[] = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[c] = 0;
		for(int i = 1;  i <= n ; i++) {

	//		System.out.println(Arrays.toString(distance));
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 1; j <= n ;j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minIndex = j;
				}
			}
			if(min == Integer.MAX_VALUE) break;
			visited[minIndex] = true;
			result[0]++;
			result[1] = Math.max(result[1], min);
			for(int j = 0; j < input[minIndex].size() ;j++) {
				int nowIndex = input[minIndex].get(j).end;
				int length = input[minIndex].get(j).weight;
		//		System.out.println(nowIndex);
				if(!visited[nowIndex] && length + min < distance[j]) {
					distance[nowIndex] = length + min;
				}
				
			}
	//		System.out.println(Arrays.toString(distance));
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			input = new ArrayList[n+1];
			for(int i = 1 ; i <= n ; i++) {
				input[i] = new ArrayList<>();
			}
			for(int i = 0 ; i < d ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
	//			System.out.printf("%d %d %d\n",b,a,s);
				input[b].add(new Node(a,s));
			}
			int[] result = dij();
			System.out.println(result[0]+" "+result[1]);
		}
	}
}
