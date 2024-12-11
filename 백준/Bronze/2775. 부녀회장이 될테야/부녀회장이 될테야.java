import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        int[][] list = new int[15][14];

        for (int j = 0; j <= 14; j++) {
            int cnt = 1;
            for (int z = 0; z < 14; z++) {

                if (j == 0) {
                    list[j][z] = cnt;
                    cnt++;
                } else {
                    int value = 0;
                    for (int v = 0; v <= z; v++) {
                        value += list[j - 1][v];
                    }
                    list[j][z] = value;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(list[k][n - 1] + "\n");
        }
        
        bw.flush();
    }
}
