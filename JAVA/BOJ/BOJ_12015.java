package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12015 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        int[] LIS = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int size = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = Arrays.binarySearch(LIS,0,size,input[i]);
            if(temp < 0){
                temp = Math.abs(temp) - 1;
                LIS[temp] = input[i];
                if(size == temp) size++;
            }
        }
        System.out.println(size);
    }
}
