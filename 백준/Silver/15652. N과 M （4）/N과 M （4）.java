import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int[] temp;
    static int m = 0;
    static int n = 0;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        temp = new int[m];
        backTraking(0, 1);
        bw.flush();
    }

    public static void backTraking(int depth, int now) throws Exception {
 
        if (depth == m) {
            for (int i = 0; i < temp.length; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = now; i <= n; i++) {
            temp[depth] = i;
            backTraking(depth + 1, i);
        }
    }
}
