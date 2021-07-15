package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n , c;
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] input = new int[n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            input[i] =Integer.parseInt(st.nextToken());

        }
        Arrays.sort(input);
        int arr[] = new int[n-1];
        for(int i = 0 ; i < n-1 ; i++){
            arr[i] = input[i+1] - input[i];
        }
        int min = 0;
        int max = Integer.MAX_VALUE;
        int result = 0;
        while(min <= max){
            int mid = (min + max)/2;
//            System.out.println(min + " "+max+" "+mid+" "+result);
            if(cal(arr,n-1,mid,c)){
                result = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
//            break;
        }
        System.out.println(result);
    }

    private static boolean cal(int[] input,int n,int mid,int c) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0 ; i < n ;i++){
            sum += input[i];
            if(sum >= mid){
                sum = 0;
                cnt++;
                if(cnt >= c) return true;
            }
        }
        return false;
    }
}

