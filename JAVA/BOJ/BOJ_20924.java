package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class BOJ_20924 {
	static int n , r;
	static List<Node>[] list;
	static int result[] = new int[2]; // 0 giga , 1 가지
	static int[] findgiga(int now, int prev) {
		int size = 0;
		int index = 0 ;
		for(int i = 0 ; i <list[now].size()  ; i++) {
			if(list[now].get(i).end != prev) {size++; index = i;}
		}
		if(size == 1) {
			result[0] += list[now].get(index).weight;
			return findgiga(list[now].get(index).end,now);
		}else {
			return new int[] {now,prev};
		}
	}
	static int findleaf(int now, int prev) {
		int result = 0;
		for(int i = 0 ; i < list[now].size(); i++) {
			Node nowNode = list[now].get(i);
			if(nowNode.end != prev) {
				result = Math.max(result, findleaf(nowNode.end,now)+nowNode.weight);				
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 0 ; i <= n ;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		int[] temp = findgiga(r,-1);
		result[1] = findleaf(temp[0],temp[1]);
		System.out.println(result[0]+" "+result[1]);
		
	}
}
