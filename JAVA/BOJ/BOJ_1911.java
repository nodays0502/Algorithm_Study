package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1911 {
	static int N, L;
	static int size = 0;
	static List<int[]> input = new LinkedList<>();
	static int cal(int depth, int cover) {
		if(depth == input.size()) {
			return 0;
		}else {
			int result = 0;
			int[] now = input.get(depth);
			int max = now[1];
			int min = now[0];
			if(cover > now[0]) min = cover;
			int length = max - min;
			result = (length) / L;
			System.out.println(max+" "+min+" "+result+" "+cover);
			if(length % L > 0) { result += cal(depth+1 , min+(result+1)*L)+1;}
			else { result += cal(depth+1 , min+result*(L));}
			return result;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int min = Integer.parseInt(st.nextToken()); 
			int max = Integer.parseInt(st.nextToken());

			input.add(new int[] {min,max});
		}
		Collections.sort( input , (o1 , o2) -> {return o1[0]-o2[0];});
		System.out.println(cal(0,0));
	}
}
