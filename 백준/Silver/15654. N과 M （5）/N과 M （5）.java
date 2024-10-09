import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int[] list;
    static boolean[] visit;
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

        list = new int[n];
        visit =  new boolean[n];
        temp = new int[m];

        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(val[i]);
        }

        Arrays.sort(list);
        backTraking(0);
        bw.flush();
    }

    public static void backTraking(int depth) throws Exception {

        if (depth == m) {
            for (int i = 0; i < temp.length; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            temp[depth] = list[i];
            backTraking(depth + 1);
            visit[i] = false;
        }
    }
}
