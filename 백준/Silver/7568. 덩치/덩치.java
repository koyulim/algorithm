import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < n; i++) {
            int x = list[i][0];
            int y = list[i][1];
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && x < list[j][0] && y < list[j][1]) cnt++;
            }
            bw.write(cnt + " ");
        }

        bw.flush();
    }
}
