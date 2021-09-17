package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10972 {
    static int n;
    static int input[];
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int i = n-1;
        while(i>0 && input[i-1] >= input[i] ) i--;
        if(i == 0){
            System.out.println(-1);
            return;
        }
        int j = n-1;
        while(input[i-1]  >= input[j]) j--;

        swap(i-1,j);

        int k = n-1;
        while(i < k){
            swap(i++,k--);
        }

        for(int a = 0 ; a < n ; a++){
            System.out.print(input[a]+" ");
        }

    }
    private static void swap(int i , int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
