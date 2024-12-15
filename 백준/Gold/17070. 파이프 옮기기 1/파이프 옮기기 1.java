import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][][] dp = new int[n][n][3];
        dp[0][1][0] = 1;

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                if (list[r][c] == 1) continue;

                if (c - 1 >= 0 && list[r][c - 1] == 0) {
                    dp[r][c][0] += dp[r][c - 1][0];
                    dp[r][c][0] += dp[r][c - 1][2];
                }

                if (r - 1 >= 0 && list[r - 1][c] == 0) {
                    dp[r][c][1] += dp[r - 1][c][1];
                    dp[r][c][1] += dp[r - 1][c][2];
                }

                if (r - 1 >= 0 && c - 1 >= 0 &&
                    list[r - 1][c] == 0 && list[r][c - 1] == 0 && list[r - 1][c - 1] == 0) {
                    dp[r][c][2] += dp[r - 1][c - 1][0];
                    dp[r][c][2] += dp[r - 1][c - 1][1];
                    dp[r][c][2] += dp[r - 1][c - 1][2];
                }
            }
        }

        bw.write((dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]) + "\n");
        bw.flush();
    }
}
