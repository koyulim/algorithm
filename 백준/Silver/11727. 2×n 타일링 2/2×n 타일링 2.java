import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if ((i % 2) == 0) dp[i] = ((dp[i - 1] * 2) + 1) % 10007;
            else dp[i] = ((dp[i - 1] * 2) - 1) % 10007;
        }   

        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
