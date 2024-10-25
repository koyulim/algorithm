import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] dp = new int[k + 1][n + 2];

        for (int i = 1; i <= n; i++) {
            String[] inputVal = br.readLine().split(" ");
            int w = Integer.parseInt(inputVal[0]);
            int v = Integer.parseInt(inputVal[1]);

            for (int j = 0; j <= k; j++) {
                if (w <= j) {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - w][i - 1] + v);
                } else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }

        bw.write(dp[k][n] + "\n");
        bw.flush();
    }
}
