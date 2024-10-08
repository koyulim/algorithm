import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int n = 0;
    static int m = 0;
    static int[] temp;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        temp = new int[m];
        backtraking(0, 1);

        bw.flush();
    }

    public static void backtraking(int deapts, int leng) throws IOException {
        if (deapts == m) {
            for (int i = 0; i < temp.length; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = leng; i <= n; i++) {
            temp[deapts] = i;
            backtraking(deapts + 1, i + 1);
        }
    }

}
