import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] list = new int[size][size];
        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = list[0][0];
        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i - 1][0] + list[i][0];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + list[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            result = Math.max(result, dp[size - 1][i]);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
