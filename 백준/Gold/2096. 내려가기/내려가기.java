import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] list = new int[size][3];

        int[][] maxDp = new int[size][3];
        int[][] minDp = new int[size][3];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        maxDp[0][0] = list[0][0];
        maxDp[0][1] = list[0][1];
        maxDp[0][2] = list[0][2];
        minDp[0][0] = list[0][0];
        minDp[0][1] = list[0][1];
        minDp[0][2] = list[0][2];

        for (int i = 1; i < size; i++) {
            
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + list[i][0];
            maxDp[i][2] = Math.max(maxDp[i - 1][2], maxDp[i - 1][1]) + list[i][2];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + list[i][1];
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + list[i][0];
            minDp[i][2] = Math.min(minDp[i - 1][2], minDp[i - 1][1]) + list[i][2];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + list[i][1];

        }

        bw.write(Math.max(Math.max(maxDp[size - 1][0], maxDp[size - 1][1]), maxDp[size - 1][2]) + " " + Math.min(Math.min(minDp[size - 1][0], minDp[size - 1][1]), minDp[size - 1][2]) + "\n");
        bw.flush();
    }
}
