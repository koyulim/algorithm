import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[] temp;
    static int[] list;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        list = new int[n];
        temp = new int[m];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list);
        backTraking(0, 0);
        bw.flush();
        bw.close();
    }

    public static void backTraking(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int val = -1;
        for (int i = start; i < n; i++) {
            if (list[i] != val) {
                temp[depth] = list[i];
                val = list[i];
                backTraking(depth + 1, i);
            }
        }
    }

}
