import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] list = new int[size][3];
        int[][] dp = new int[size][3];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = list[0][0];
        dp[0][1] = list[0][1];
        dp[0][2] = list[0][2];

        for (int i = 1; i < size; i++) {            
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];
        }

        int result = 0;
        result = Math.min(dp[size - 1][0], dp[size - 1][1]);
        result = Math.min(result, dp[size - 1][2]);

        bw.write(result + "\n");
        bw.flush();
    }
}
