import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3273 {
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
			int temp = x - input[i];
			int index = Arrays.binarySearch(input, temp);
		//	System.out.println(temp);
		//	System.out.println(index);
			if(index >= 0)
				result++;
		}
		System.out.println(result / 2);
	}

}
