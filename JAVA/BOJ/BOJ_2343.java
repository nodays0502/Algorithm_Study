package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
	static int n,m,input[];
	static int LIMIT = 100000 * 10000;// 1000000000 
	static long cal() {
		long result = LIMIT;
		long low = 0;
		long high = LIMIT;
		while(low <= high) {
			long mid = (low+high)/2;
			if(checking(mid)) {
	//			System.out.println(mid);
				result = Math.min(result, mid);
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return result;
	}
	static boolean checking(long num) {
		int cnt= 0;
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			if(input[i] > num) return false;
			sum += input[i];
		//	System.out.println(sum);
			if(sum > num) {
				cnt++;
				sum = input[i];
			}
			if(cnt >= m ) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		st= new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(cal());
	}
}
