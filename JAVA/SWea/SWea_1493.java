package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_1493 {
	static int map[][] = new int[300][300];
	static int[] makexy(int target) {
		int near;
		for(near = 0 ; near < 1000 ; near++) {
			if(target < (near*(near+1))/2) break;
			if(target == (near*(near+1))/2) {return new int[] {near,1};}
		}
		for(int i = 1 ; near+1-i >= 1; i++) {
			if(map[i][near-i+1] == target) {
				return new int[] {i , near - i + 1};
			}
		}
		return new int[] {0,0};
	}
	static int makeValue(int[] yx) {
	//	System.out.println(yx[0]+" "+yx[1]);
		return map[yx[0]][yx[1]];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int value = 1;
		for(int sum = 2 ; sum < 300 ; sum++) {
			for(int i = 1 ; sum-i >= 1 ; i++) {
				map[i][sum-i] = value++;
		//		if(value == 10003) break;
			}
		}
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			int result = 0;
			st = new StringTokenizer(br.readLine()," ");
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			int[] target1yx = makexy(target1);
			int[] target2yx = makexy(target2);
			result = makeValue(new int[] {target1yx[0] + target2yx[0] , target1yx[1] + target2yx[1]});
			System.out.println("#"+t+" "+result);
		}
	}

}
