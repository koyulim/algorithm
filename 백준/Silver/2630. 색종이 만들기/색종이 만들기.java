import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int[][] list;
    static int whiet = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        list = new int[n][n];

        for (int i = 0; i< n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        divide(0, 0, n);
        bw.write(whiet + "\n");
        bw.write(blue + "\n");
        bw.flush();
    }

    public static void divide(int x, int y, int z) {
        
        int start = list[x][y];

        if (z == 1) {
            if (start == 0) {
                whiet++;
            } else {
                blue++;
            }
            return;
        }

        boolean chaeck = true;
        for (int i = x; i < x +z; i++) {
            for (int j = y; j < y + z; j++) {
                if (list[i][j] != start) {
                    chaeck = false;
                    break;
                }
            }
            
            if (!chaeck) {
                break;
            }
        }

        if (chaeck) {
            if (start == 0) {
                whiet++;
            } else{
                blue++;
            }
            return;
        }

        int size = z / 2;
        divide(x, y, size);
        divide(x + size, y, size);
        divide(x, y + size, size);
        divide(x + size, y + size, size);
    }
}
