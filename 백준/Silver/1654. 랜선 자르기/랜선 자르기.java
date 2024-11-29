import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        long[] list = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            long val = Long.parseLong(br.readLine());
            list[i] = val;
            if (max < val) max = val;
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long cnt = 0;
            long mid = (left + right) / 2;
            for (long num : list) {
                cnt += num / mid;
            }

            if (cnt >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
