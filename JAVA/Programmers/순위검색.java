import java.util.*;
import java.io.*;
class Solution {
    List<Integer>[][][][] list;
    Map<String,Integer> map = new HashMap();
    public void init(){
        list = new List [4][3][3][3]; // lang, job, career, food
        map.put("cpp",1);
        map.put("java",2);
        map.put("python",3);
        
        map.put("backend",1);
        map.put("frontend",2);
        
        map.put("junior",1);
        map.put("senior",2);
        
        map.put("chicken",1);
        map.put("pizza",2);
        map.put("-", 0);
        
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3; k++){
                    for(int l = 0 ; l < 3; l++){
                        list[i][j][k][l] = new ArrayList<>();
                    }
                }
            }
        }
    }
    public void sort(){
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3; k++){
                    for(int l = 0 ; l < 3; l++){
                        Collections.sort(list[i][j][k][l]);
                    }
                }
            }
        }
    }
    public void add(int a,int b ,int c, int d,int num){ // lang, job, career, food  // 0 = "-"
        // for(int i = 0 ; i < 4; i++){
        //     if(i != a && i != 0) continue; // a하고 0만 통과
        //     for(int j = 0 ; j < 3; j++){
        //         if(j != b && j != 0) continue; // b하고 0만 통과
        //         for(int k = 0 ; k < 3 ; k++){
        //             if(k != c && k != 0) continue;// c하고 0만 통과
        //             for(int l = 0 ; l < 3; l++){
        //                 if(l != d && l != 0) continue; // d하고 0만 통과
        //                 list[i][j][k][l].add(num);
        //             }
        //         }
        //     }
        // }
        list[a][b][c][d].add(num);
        list[0][b][c][d].add(num);
        list[a][0][c][d].add(num);
        list[a][b][0][d].add(num);
        list[a][b][c][0].add(num);
        list[0][0][c][d].add(num);
        list[0][b][0][d].add(num);
        list[0][b][c][0].add(num);
        list[a][0][0][d].add(num);
        list[a][0][c][0].add(num);
        list[a][b][0][0].add(num);
        list[0][0][0][d].add(num);
        list[0][0][c][0].add(num);
        list[0][b][0][0].add(num);
        list[a][0][0][0].add(num);
        list[0][0][0][0].add(num);
        
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        init();
        for(int i = 0 ; i < info.length ; i++){ // 50,000 * 4* 3*3*3 = 50,000 * 108 =  5백만쯤
            String temp[] = info[i].split(" ");
            // list[map.get(temp[0])][map.get(temp[1])][map.get(temp[2])][map.get(temp[3])].add(Integer.parseInt(temp[4])); 
            // list[0][0][0][0].add(Integer.parseInt(temp[4])); 
            add(map.get(temp[0]),map.get(temp[1]),map.get(temp[2]),map.get(temp[3]),Integer.parseInt(temp[4]));
            // System.out.println(Arrays.toString(temp));
        }
        
        
        sort(); // 300 * 4 * 3 * 3 *3  = 쩌리
        
        
        for(int i = 0 ; i < query.length ; i++){ // 100,000 * log(50,000) = 100,000 * 300 = 3천만
            String temp[] = query[i].split(" ");
            int num = Integer.parseInt(temp[7]);
            int start = 0;
            int end = list[map.get(temp[0])][map.get(temp[2])][map.get(temp[4])][map.get(temp[6])].size();
            while(start < end){
                int mid = (start+end) / 2;
                if(list[map.get(temp[0])][map.get(temp[2])][map.get(temp[4])][map.get(temp[6])].get(mid) < num){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }



            // System.out.println(list[map.get(temp[0])][map.get(temp[2])][map.get(temp[4])][map.get(temp[6])]);

            answer[i] = list[map.get(temp[0])][map.get(temp[2])][map.get(temp[4])][map.get(temp[6])].size() - start;
        }
        
        return answer;
    }
}
