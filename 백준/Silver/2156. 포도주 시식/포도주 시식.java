import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        if (size == 1) {
            bw.write(list[0] + "\n");
            bw.flush();
            return;
        }

        dp[0] = list[0];
        dp[1] = list[0] + list[1];

        if (size > 2) {
            dp[2] = Math.max(dp[1], Math.max(list[0] + list[2], list[1] + list[2]));
        }

        for (int i = 3; i < size; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + list[i], dp[i - 3] + list[i - 1] + list[i]));
        }

        bw.write(dp[size - 1] + "\n");
        bw.flush();
    }
}
