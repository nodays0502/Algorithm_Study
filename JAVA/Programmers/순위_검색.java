package self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 순위_검색 {
    static List<Integer> list[][][][] = new ArrayList[4][3][3][3];
    static void makeList(String[] info){
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j< 3 ; j++){
                for(int k = 0 ; k < 3; k++){
                    for(int l = 0 ; l < 3; l++){
                        list[i][j][k][l] = new ArrayList<>();
                    }
                }
            }
        }
        for(int i = 0 ; i < info.length ; i++){
            String[] temp = info[i].split(" ");
            int condition[] = new int[4];
            if(temp[0].equals("cpp"))
                condition[0] = 0;    
            else if(temp[0].equals("java"))
                condition[0] = 1;
            else if(temp[0].equals("python"))
                condition[0] = 2;
            
            if(temp[1].equals("backend"))
                condition[1] =  0;
            else if(temp[1].equals("frontend"))
                condition[1] =  1;
            
            if(temp[2].equals("junior"))
                condition[2] =  0;
            else if(temp[2].equals("senior"))
                condition[2] =  1 ;
            
            if(temp[3].equals("chicken"))
                condition[3] =  0;
            else if(temp[3].equals("pizza"))
                condition[3] =  1;

        //    list[condition[0]][condition[1]][condition[2]][condition[3]].add(Integer.parseInt(temp[4]));
        //    list[3][2][2][2].add(Integer.parseInt(temp[4]));
            for(int a = 0 ; a < 4; a++){
                if(a == condition[0] || a == 3)
                for(int j = 0 ; j< 3 ; j++){
                    if(j == condition[1] || j == 2)
                    for(int k = 0 ; k < 3; k++){
                        if(k == condition[2] || k == 2)
                        for(int l = 0 ; l < 3 ; l++){
                            if(l == condition[3] || l == 2)
                                list[a][j][k][l].add(Integer.parseInt(temp[4]));
                        }
                    }
                }
            }   
        }
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j< 3 ; j++){
                for(int k = 0 ; k < 3; k++){
                    for(int l = 0 ; l < 3 ; l++){
                        Collections.sort(list[i][j][k][l]);
                    }
                }
            }
        }
        
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        makeList(info);
        for(int t = 0 ; t < query.length ; t++){
            String[] temp = query[t].split(" ");
            int condition[] = new int[4];

            if(temp[0].equals("cpp"))
                condition[0] = 0;    
            else if(temp[0].equals("java"))
                condition[0] = 1;
            else if(temp[0].equals("python"))
                condition[0] = 2;
            else if(temp[0].equals("-"))
                condition[0] = 3;
            
            if(temp[2].equals("backend"))
                condition[1] =  0;
            else if(temp[2].equals("frontend"))
                condition[1] =  1;
            else if(temp[2].equals("-"))
                condition[1] = 2;
            
            if(temp[4].equals("junior"))
                condition[2] =  0;
            else if(temp[4].equals("senior"))
                condition[2] =  1 ;
            else if(temp[4].equals("-"))
                condition[2] = 2;
            
            if(temp[6].equals("chicken"))
                condition[3] =  0;
            else if(temp[6].equals("pizza"))
                condition[3] =  1;
            else if(temp[6].equals("-"))
                condition[3] = 2;
        
        
  //      System.out.println(Arrays.toString(condition));
            int num = Integer.parseInt(temp[7]);
            int start = 0;
            int end = list[condition[0]][condition[1]][condition[2]][condition[3]].size();
            // lower bound 를 구해야 함
            while (start < end) {
                int mid = (start + end) / 2;
                if(list[condition[0]][condition[1]][condition[2]][condition[3]].get(mid) < num) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            /*                
            int index = list[condition[0]][condition[1]][condition[2]][condition[3]].size();
            for(int a = 0 ; a < list[condition[0]][condition[1]][condition[2]][condition[3]].size() ; a++){
                if(num <= list[condition[0]][condition[1]][condition[2]][condition[3]].get(a) ){
                    index = a;
                    break;
                }
            }*/
  //          System.out.println(Arrays.toString(condition));
  //          System.out.println(list[condition[0]][condition[1]][condition[2]][condition[3]]);
            int result = list[condition[0]][condition[1]][condition[2]][condition[3]].size() - start;


                            
            answer[t] = result; 
            
        }
        return answer;
    }
}