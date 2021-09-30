import java.util.*;
class Solution {
    static Map<Integer,int[]> coord = new HashMap<>();
    /*
    1 2 3
    4 5 6
    7 8 9
    * 0 #
    */
    static void init(){
        coord.put(1,new int[]{0,0});
        coord.put(2,new int[]{0,1});
        coord.put(3,new int[]{0,2});
        coord.put(4,new int[]{1,0});
        coord.put(5,new int[]{1,1});
        coord.put(6,new int[]{1,2});
        coord.put(7,new int[]{2,0});
        coord.put(8,new int[]{2,1});
        coord.put(9,new int[]{2,2});
        coord.put(0,new int[]{3,1});
    }
    static int distance(int[] hand , int num){
        int[] numCoord = coord.get(num);
        return Math.abs(hand[0] - numCoord[0]) + Math.abs(hand[1] - numCoord[1]); 
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        init();
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};
        for(int number : numbers){
            boolean changeLeft = false;
            if(number == 1 || number == 4 || number == 7){
                changeLeft = true;
            }else if(number == 3 || number == 6 || number == 9){
                changeLeft = false;
            }else{
                int leftDis = distance(left,number);
                int rightDis = distance(right,number);
                if(leftDis == rightDis){
                    if("right".equals(hand)){
                        changeLeft = false;
                    }else{
                        changeLeft = true;
                    }
                }else if(leftDis < rightDis){
                    changeLeft = true;
                }else{
                    changeLeft = false;
                }
            }
            if(changeLeft){
                sb.append('L');
                left = coord.get(number);
            }else{
                sb.append('R');
                right = coord.get(number);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
