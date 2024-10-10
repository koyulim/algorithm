import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] list = new int[size];
        int[] dp = new int[size];
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(input[i]);
            dp[i] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            cnt = Math.max(cnt, dp[i]);
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
