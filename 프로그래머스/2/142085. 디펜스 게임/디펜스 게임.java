import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < enemy.length; i++) {
            if (i < k) {
                queue.add(enemy[i]);
            } else {
                
                int num = enemy[i];
                
                if (enemy[i] > queue.peek()) {
                    num = queue.poll();
                    queue.add(enemy[i]);
                } 
                
                if (num <= n) {
                    n = n - num;
                } else {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}