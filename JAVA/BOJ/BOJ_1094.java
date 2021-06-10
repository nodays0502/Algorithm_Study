package bitmask;

import java.util.Scanner;

public class BOJ_1094 {
	static int x, sum = 0;
	static int stick = 64;
	static int cal() {
		int result = 1;
		sum = stick;
		while(sum > x) {
//			System.out.println("sum"+sum);
//			System.out.println("stick"+stick);
			sum -= stick;
			stick = stick >> 1;
			sum += stick;
			if(sum >= x) {
				;
			}else {
				sum += stick;
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		System.out.println(cal());
	}
}
