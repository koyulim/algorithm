import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmb = br.readLine().split(" ");
        int n = Integer.parseInt(nmb[0]);
        int m = Integer.parseInt(nmb[1]);
        int b = Integer.parseInt(nmb[2]);

        Map<Integer, Integer> map = new HashMap<>();
        int minHeight = 256;
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(input[j]);
                map.put(val, map.getOrDefault(val, 0) + 1);
                minHeight = Math.min(minHeight, val);
                maxHeight = Math.max(maxHeight, val);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int standard = minHeight; standard <= maxHeight; standard++) {
            int blockNeed = 0;
            int blockRemove = 0;

            for (int entry : map.keySet()) {
                if (entry < standard) {
                    blockNeed += (standard - entry) * map.get(entry);
                } else if (entry > standard) {
                    blockRemove += (entry - standard) * map.get(entry);
                }
            }

            if (blockRemove + b >= blockNeed) {
                int nTime = blockRemove * 2 + blockNeed;
                
                if (nTime < time || (nTime == time && standard > height)) {
                    time = nTime;
                    height = standard;
                }
            }
        }

        bw.write(time + " " + height + "\n");
        bw.flush();
    }
}
