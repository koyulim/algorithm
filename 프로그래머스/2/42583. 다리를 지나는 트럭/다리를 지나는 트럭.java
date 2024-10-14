import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> wait = new LinkedList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            int[] list = new int[2];
            list[0] = 0;
            list[1] = truck_weights[i];
            wait.add(list);
        }
        
        int time = 0;
        int truckW = 0;
        Queue<int[]> leng = new LinkedList<>();
        while (!leng.isEmpty() || !wait.isEmpty()) {
            time++;
            
            if (!wait.isEmpty()) {
                int[] list = wait.peek();
                int p = list[0];
                int w = list[1];
                
                if (truckW + w <= weight) {
                    truckW = truckW + w;
                    leng.add(wait.poll());
                }
                
            }
            
            int cnt = 0;
            int size = leng.size();
            while (cnt < size) {
                int[] list = leng.poll();
                int p = list[0];
                int w = list[1];
                
                if (bridge_length == p + 1) {
                    truckW = truckW - w;
                } else {
                    list[0] = p + 1;
                    leng.add(list);
                }
                cnt++;
            }
            
        }
        
        return time + 1;
    }
}