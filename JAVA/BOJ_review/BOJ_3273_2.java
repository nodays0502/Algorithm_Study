import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3273_2 {
	static int n;
	static int input[];
	static int x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = sc.nextInt();
		}
		x = sc.nextInt();
		Arrays.sort(input);
		int result = 0 ;
		for(int i = 0 ; i < n ; i++) {
			int target = x - input[i];
			int first = 0;
			int last = n-1;
			int mid = 0;
			while(first <= last) {
				mid = (first+last)/2;
				if(input[mid] == target) {
					result++;
					break;
				}else {
					if(target < input[mid]) {
						last = mid-1;
					}else {
						first = mid+1;
					}
				}
			}
		}
		System.out.println(result / 2);
	}

}
