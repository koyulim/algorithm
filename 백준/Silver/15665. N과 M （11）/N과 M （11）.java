import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static TreeSet<Integer> list;
    static int[] temp;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        list = new TreeSet<>();
        temp = new int[m];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        backTraking(0);
        bw.flush();
    }

    public static void backTraking(int dept) throws IOException {
        if (dept == m) {
            for (int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i : list) {
            temp[dept] = i;
            backTraking(dept + 1);
        }
    }
}
