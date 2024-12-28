import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int x = 0;
        int y = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                x = Math.max(sizes[i][0], x);
                y = Math.max(sizes[i][1], y);
            } else {
                x = Math.max(sizes[i][1], x);
                y = Math.max(sizes[i][0], y);
            }
        }
        
        return x * y;
    }
}