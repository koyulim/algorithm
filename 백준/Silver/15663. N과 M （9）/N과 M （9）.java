import java.util.*;
import java.io.*;

public class Main {

    static int[] temp;
    static int m = 0;
    static int n = 0;
    static int[] list;
    static boolean[] visit;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new int[n];
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(val[i]);
        }
        temp = new int[m];
        visit = new boolean[n];
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

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (visit[i] || list[i] == prev) continue;
            visit[i] = true; 
            temp[depth] = list[i];
            prev = list[i];
            backTraking(depth + 1);
            visit[i] = false;
        }
    }
}
