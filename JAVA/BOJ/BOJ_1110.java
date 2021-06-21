import java.util.Scanner;

public class BOJ_1110 {
	static int n;
	static int cal(int num) {
		int result = 0;
		int temp = num / 10 + num % 10;
		result = (num % 10)*10 + temp%10; 
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int result = 1;
		int temp = cal(n);
		while(temp != n) {
			temp = cal(temp);
			result++;
		}
		System.out.println(result);
	}
}
