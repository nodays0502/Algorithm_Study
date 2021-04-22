class Solution {

    public String solution(int n) {
        String answer = "";
        StringBuilder result = new StringBuilder();

        while(true){
            if(n % 3 == 0){n/=3;n--; result.append("4");}
            else if(n % 3 == 1){n/=3; result.append("1");}
            else if(n % 3 == 2){n/=3; result.append("2");}
            if(n <= 0) break;
        }
        answer = result.reverse().toString();
        return answer;
    }
}
