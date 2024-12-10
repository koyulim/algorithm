import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        long v = 1;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                result += (5 * i) - ((2 * v) + 1);
                v++;
            } else {
                result += 5 * n;
            }

            result %= 45678;
        }

        bw.write((result % 45678) + "\n");
        bw.flush();
    }
}
