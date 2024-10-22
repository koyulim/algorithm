import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] list = new int[2][size];
            int[][] dp = new int[2][size];
            int result = 0;

            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int z = 0; z < size; z++) {
                    list[j][z] = Integer.parseInt(input[z]);
                }
            }

            if (size == 1) {
                result = Math.max(list[0][size - 1], list[1][size - 1]);
                bw.write(result + "\n");
                continue;
            }

            dp[0][0] = list[0][0];
            dp[1][0] = list[1][0];
            dp[0][1] = dp[1][0] + list[0][1];
            dp[1][1] = dp[0][0] + list[1][1];
            
            for (int j = 2; j < size; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + list[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + list[1][j];
            }

            result = Math.max(dp[0][size - 1], dp[1][size - 1]);
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
