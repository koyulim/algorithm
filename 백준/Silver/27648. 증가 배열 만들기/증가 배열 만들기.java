import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        if (n + m - 1 > k) {
            bw.write("NO" + "\n");
        } else {
            bw.write("YES" + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bw.write((i + j + 1) + " ");
                }
                bw.write("\n");
            }
        }
        
        bw.flush();
    }
}
