import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
            dp[i] = 1;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = Math.max(cnt, dp[i]);
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
