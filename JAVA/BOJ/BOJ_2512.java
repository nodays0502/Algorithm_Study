package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
	static int input[];
	static int n;
	static int m;
	static int binearySear(int max) {
		int low = 0;
		int high = max;
		int result = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			int sum = cal(mid);
			if(sum == m) {
				result = mid;
				break;
			}else if(sum < m) {
				result = Math.max(result,mid);
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return result;
	}
	static int cal(int num) {
		int sum = 0 ;
		for(int i = 0 ; i < n ; i++) {
			sum += Math.min(input[i], num);
		}
		return sum;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int max = 0 ;
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, input[i]);
		}
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		System.out.println(binearySear(max));
	}
}
