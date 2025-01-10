import java.io.*;
import java.util.*;

public class Main {

    static int[] list;
    static int n;
    static int m;
    static boolean[] visit;
    static int[] temp;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        list = new int[n + 1];
        temp = new int[m + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = i;
        }

        backTraking(0);
        bw.close();
    }

    static void backTraking(int index) throws IOException {
        
        if (index == m) {

            for (int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[index] = list[i];
            backTraking(index + 1);
            visit[i] = false;
        }
    }
}
