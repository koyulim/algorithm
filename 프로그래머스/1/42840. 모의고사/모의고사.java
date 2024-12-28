import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] therd = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstCnt = 0;
        int secondCnt = 0;
        int therdCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (first[i % 5] == answers[i]) firstCnt++;
            if (second[i % 8] == answers[i]) secondCnt++;
            if (therd[i % 10] == answers[i]) therdCnt++;
        }
        
        int max = 0;
        max = Math.max(firstCnt, secondCnt);
        max = Math.max(therdCnt, max);
        List<Integer> arr = new ArrayList<>();
        if (firstCnt == max) arr.add(1);
        if (secondCnt == max) arr.add(2);
        if (therdCnt == max) arr.add(3);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}