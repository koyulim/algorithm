import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        boolean[] chack = new boolean[m + 1];
        chack[0] = true;
        chack[1] = true;

        for (int i = 2; i * i <= m; i++) {
            if (!chack[i]) {
                for (int j = i * i; j <= m; j += i) {
                    chack[j] = true;
                }
            }
        }

        for (int i = n; i <= m; i++) {
            if (!chack[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}
