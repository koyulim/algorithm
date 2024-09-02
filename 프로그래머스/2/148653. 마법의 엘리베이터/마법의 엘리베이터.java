import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int now = storey % 10;
            if (now > 5) {
                answer += 10 - now;
                storey = storey + (10 - now);
            } else if (now < 5){
                answer += now;
            } else {
                if ((storey / 10) % 10 >= 5) {
                    answer += 10 - now;
                    storey = storey + (10 - now);
                } else {
                    answer += now;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}