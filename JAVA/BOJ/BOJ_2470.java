package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2470 {
    static int a = 0, b = 0;
    static int result =  2 * 1_000_000_000;
    static void binarySearch(int [] input, int index ,int n){
        int target = -input[index];
        int start = index + 1;
        int end = n - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            int now = input[index] + input[mid];
            if (result > Math.abs(now)) {
                a = input[index];
                b = input[mid];
                result = Math.abs(now);
//                System.out.println(result+" "+a+" "+b);
            }
            if(input[mid] > target){
                end = mid - 1;
            }else if(input[mid] < target){
                start = mid + 1;
            }else{
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(input);
//        System.out.println(Arrays.toString(input));
        for(int i = 0 ; i < n ; i++){
            binarySearch(input, i, n);
        }
        System.out.println(a + " " + b);
    }
}
