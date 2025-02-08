import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        String[] city = br.readLine().split(" ");
        int value = parent[Integer.parseInt(city[0])];
        for (int i = 1; i < m; i++) {
            if (value != parent[Integer.parseInt(city[i])]) {
                bw.write("NO" + "\n");
                bw.flush();
                return;
            }
        }

        bw.write("YES" + "\n");
        bw.flush();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
