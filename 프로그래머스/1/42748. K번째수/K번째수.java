import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int n = commands[i][0] - 1;
            int m = commands[i][1];
            int v = commands[i][2];

            List<Integer> arr = new ArrayList<>();
            for (int j = n; j < m; j++) {
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            answer[i] = arr.get(v - 1);
        }
        
        
        return answer;
    }
}