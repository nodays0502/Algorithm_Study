package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {

    static List<Integer> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            checkPirme(i);
        }
        int si = 0;
        int ei = 0;
        int sum = 0;
        int result = 0;
//        System.out.println(list);
        while(true){
//            System.out.println(sum);
            if(sum < n){
                if(ei >= list.size()){
                    break;
                }
                sum+=list.get(ei++);
            }else if(sum == n){
                result++;
                sum -=list.get(si++);
            }else{ // sum > n
                sum-=list.get(si++);
            }
        }
        System.out.println(result);
    }

    private static void checkPirme(int num) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.add(num);
        }

    }
}
