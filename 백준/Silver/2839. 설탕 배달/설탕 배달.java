import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[5000 + 1];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;
    
        for (int i = 6; i <= n; i++) {
            int left = 3;
            int right = i - left;
            int min = Integer.MAX_VALUE;
            while (left <= right) {
                if (dp[left] != -1 && dp[right] != -1) min = Math.min((dp[left] + dp[right]), min);
                left++;
                right--;
            }

            if (min == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = min;
        }

        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
