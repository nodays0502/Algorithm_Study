package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2941 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        int[] input = new int[comm.length()];
        for(int i = 0 ; i < comm.length(); i++){
            input[i] = comm.charAt(i) - '0';
        }
        Arrays.sort(input);
        for(int i = input.length -1 ; i >= 0 ; i--){
            System.out.print(input[i]);
        }
    }
}
