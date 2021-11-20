package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NO_3_A {
    static int SIZE = 8;
    static Map<Character,Integer> col= new HashMap<>();
    static Map<Character,Integer> row = new HashMap<>();
    static void cal(int srow, int scol, int erow , int ecol){
        System.out.println(Math.max(Math.abs(srow-erow),Math.abs(scol-ecol)));
        while(srow != erow || scol != ecol){
            if(srow < erow){ // 가로에서 end가 더 크면
                srow++;
                System.out.print('R');
            }else if(srow > erow){
                srow--;
                System.out.print('L');
            }

            if(scol < ecol){ // 세로
                scol++;
                System.out.print('D');
            }else if(scol > ecol){
                scol--;
                System.out.print('U');
            }
            System.out.println();// ->
        }
    }
    static void init(){
        for(int i = 0 ; i < SIZE ; i++){
            char now = (char) ('8' - i);
            col.put(now, i);
            char alpha = (char) ('a' + i);
            row.put(alpha,i);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String pot = st.nextToken();
        init();
        int srow = row.get(pot.charAt(0));
        int scol = col.get(pot.charAt(1));

        st = new StringTokenizer(br.readLine(), " ");
        pot = st.nextToken();
        int erow = row.get(pot.charAt(0));
        int ecol = col.get(pot.charAt(1));
//        System.out.printf("%d %d %d %d \n",srow,scol,erow,ecol);
        cal(srow,scol,erow,ecol);
    }
}
