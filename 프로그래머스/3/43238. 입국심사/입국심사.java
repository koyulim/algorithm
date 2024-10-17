import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long[] time = new long[times.length];
        for (int i = 0; i < times.length; i++) {
            time[i] = times[i];
        }
        
        long l = 0;
        long r = 1000000000L * 1000000000;
        
        while (l < r) {
            long m = (l + r) / 2;
            long cnt = 0;
            for (int i = 0; i < time.length; i++) cnt = cnt + (m / time[i]);
            if (n <= cnt) r = m;
            else l = m + 1;
        }
        
        return l;
    }
}