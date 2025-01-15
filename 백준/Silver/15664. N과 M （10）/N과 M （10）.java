import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] list;
    static int[] temp;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
    }

    public static void backTraking(int dept, int start) throws IOException {
        if (dept == m) {
            for (int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int pre = -1;
        for (int i = start; i < n; i++) {
            if (list[i] == pre) {
                continue;
            }
            pre = list[i];
            temp[dept] = list[i];
            backTraking(dept + 1, i + 1);
        }
    }
}
