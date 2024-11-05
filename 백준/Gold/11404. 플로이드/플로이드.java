import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int[][] list;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        list = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) list[i][j] = 0;
                else list[i][j] = Integer.MAX_VALUE; 
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
        
            if (c < list[a][b]) list[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (list[i][k] != Integer.MAX_VALUE && list[k][j] != Integer.MAX_VALUE) {
                        list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (list[i][j] == Integer.MAX_VALUE) bw.write("0" + " ");
                else bw.write(list[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
