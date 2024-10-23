import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] list = new int[n][n];
        int[][] dp = new int[n][n];
        int val = 0;
        for (int i = 0; i < n; i++) {
            String[] value = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(value[j]);
                list[i][j] = v;
                
                if (j == 0) {
                    dp[i][j] = v;
                } else {
                    dp[i][j] = dp[i][j - 1] + v;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int result = 0;
            String[] xy = br.readLine().split(" ");
            int x1 = Integer.parseInt(xy[0]) - 1;
            int y1 = Integer.parseInt(xy[1]) - 1;
            int x2 = Integer.parseInt(xy[2]) - 1;
            int y2 = Integer.parseInt(xy[3]) - 1;

            if (x1 == x2 && y1 == y2) {
                bw.write(list[x1][y1] + "\n");
                continue;
            } 

            for (int j = x1; j <= x2; j++) {
                if (y1 == 0) {
                    result += dp[j][y2];
                } else {
                    result += dp[j][y2] - dp[j][y1 - 1];
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
