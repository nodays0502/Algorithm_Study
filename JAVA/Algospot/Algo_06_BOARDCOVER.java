package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Algo_06_BOARDCOVER {
    static int n,m;
    static int map[][];
    static int [][][] block = {
        {{0,0},{0,1},{1,1}},
        {{0,0},{1,0},{1,1}},
        {{0,0},{0,1},{1,0}},
        {{0,0},{1,0},{1,-1}}
    };
    static int cal(){
        int y =-1, x= -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < m ; j++){
                if(map[i][j] == 0){
                   y = i;
                   x = j;
                   break;
                }
            }
            if(y != -1){
                break;
            }
        }
        if(y == -1) {
            return 1;
        }
        int result = 0;
        for(int type = 0 ; type < 4; type++){
            if(set(y,x,type,1)){
                result += cal();
            }
            set(y,x,type,-1);
        }
//        print();
//        System.out.println();
        return result;
    }
    static void print(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static boolean set(int y , int x,int type,int num){
        boolean flag = true;
        for(int i = 0 ; i < 3; i++){
            int ny = y + block[type][i][0];
            int nx = x + block[type][i][1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                if((map[ny][nx] += num) > 1){
                    flag = false;
                }
            }else{
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0; t < test; t++){
            st = new StringTokenizer(br.readLine()," ");
            n = stoi.apply(st.nextToken());
            m = stoi.apply(st.nextToken());
            map = new int[n][m];
            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                String command = br.readLine();
                for(int j = 0 ; j < m ; j++){
                    char now= command.charAt(j);
                    if(now == '.'){
                        cnt++;
                        map[i][j] = 0;
                    }else{
                        map[i][j] = 1;
                    }
                }
            }
            if(cnt %3 != 0){
                System.out.println(0);
            }else{
                System.out.println(cal());
            }
        }
    }
}
