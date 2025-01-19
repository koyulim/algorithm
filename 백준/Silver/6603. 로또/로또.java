import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] list;
    static boolean[] visit;
    static int[] temp;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            } else {
                String[] input = str.split(" ");
                n = Integer.parseInt(input[0]);
                m = 6;
                list = new int[n];
                visit = new boolean[n];
                temp = new int[m];
                for (int i = 1; i <= n; i++) {
                    list[i - 1] = Integer.parseInt(input[i]);
                }

                backTraking(0, 0);
                bw.write("\n");
            }
        }

        bw.flush();
    }

    public static void backTraking(int dept, int start) throws IOException {
        if (dept == m) {
            for (int i = 0; i < temp.length; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[dept] = list[i];
            backTraking(dept + 1, i);
            visit[i] = false;
        }
    }
}
