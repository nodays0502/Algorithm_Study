package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1920 {

    static int n;
    static int input[];

    static int binarySearch(int arr[], int target) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int now = input[mid];
            if (now < target) {
                start = mid + 1;
            } else if (now == target) {
                return 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        input = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(input);
        st = new StringTokenizer(br.readLine(), " ");
        int test = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int t= 0 ; t < test ; t++){
            int now = stoi.apply(st.nextToken());
            System.out.println(binarySearch(input,now));
        }
    }
}
