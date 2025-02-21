import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            
            int[][] dp = new int[n + 1][m + 1];
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 1;
            }

            for (int j = 1; j <= n; j++) {
                for (int z = j; z <= m; z++) {
                    dp[j][z] = dp[j - 1][z - 1] + dp[j][z - 1];
                }
            }

            bw.write(dp[n][m] + "\n");
        }
        bw.flush();
    }
}
