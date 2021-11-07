import java.util.*;
class Solution {
    static Map<Character,Integer> map = new HashMap<>();
    static Map<Integer,Character> rmap = new HashMap<>();
    static final int SIZE = 8; // A , C , F , J , M , N , R , T
    static boolean visited[] = new boolean[SIZE];
    static int choice[] = new int[SIZE];
    static int perm(int depth,String[] datas){
        if(depth == SIZE){
            for(String data : datas){
                int a = map.get(data.charAt(0));
                int b = map.get(data.charAt(2));
                char sign = data.charAt(3);
                int interval = Integer.parseInt(data.charAt(4)+"");
                int aIndex = 0;
                int bIndex = 0;
                for(int i = 0 ; i < SIZE ; i++){
                    if(a == choice[i]){
                        aIndex = i;
                    }
                    if(b == choice[i]){
                        bIndex = i;
                    }
                }
                int nowInterval = Math.abs(aIndex - bIndex) - 1;
                if(sign == '=' && nowInterval != interval){
                    return 0;
                }else if(sign == '<' && nowInterval >= interval){
                    return 0;
                }else if(sign == '>' && nowInterval <= interval){
                    return 0;
                }
            }
            return 1;
        }else{
            int result = 0;
            for(int i = 0 ; i < SIZE ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    choice[depth] = i;
                    result += perm(depth+1,datas);
                    visited[i] = false;
                }
            }
            return result;
        }
    }
    static void init(){
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        // rmap.put(0,'A');
        // rmap.put(1,'C');
        // rmap.put(2,'F');
        // rmap.put(3,'J');
        // rmap.put(4,'M');
        // rmap.put(5,'N');
        // rmap.put(6,'R');
        // rmap.put(7,'T');
    }
    public int solution(int n, String[] data) {
        int answer = 0;
        init();
        answer = perm(0,data);
        return answer;
    }
}
