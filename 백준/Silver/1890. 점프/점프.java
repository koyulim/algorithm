import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = list[i][j];
                if (v == 0) {
                    continue;
                }

                if (i + v < n) {
                    dp[i + v][j] += dp[i][j];
                }

                if (j + v < n) {
                    dp[i][j + v] += dp[i][j];
                }
            }
        }

        bw.write(dp[n - 1][n - 1]+ "\n");
        bw.flush();
    }
}
