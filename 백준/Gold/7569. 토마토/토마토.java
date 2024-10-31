import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]); // 5
        int n = Integer.parseInt(size[1]); // 3
        int s = Integer.parseInt(size[2]); // 2

        int[][][] list = new int[s][n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                for (int z = 0; z < m; z++) {
                    int val = Integer.parseInt(input[z]);
                    list[i][j][z] = val;
                    if (val == 1) {
                        queue.add(new int[] {i, j, z});
                    }
                }
            }
        }

        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int x = idx[1];
            int y = idx[2];
            int z = idx[0];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (ny < m && nx < n && nz < s && ny >= 0 && nx >= 0 && nz >= 0) {
                    if (list[nz][nx][ny] == 0) {
                        queue.add(new int[] {nz, nx, ny});
                        list[nz][nx][ny] = list[z][x][y] + 1;
                    }
                }
            }
        }

        int result = 0;
        boolean check = false;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < m; z++) {
                    if (list[i][j][z] == 0) {
                        check = true;
                    }
                    result = Math.max(result, list[i][j][z]);
                }
            }
        }

        if (check) {
            bw.write("-1" + "\n");
        } else {
            bw.write((result - 1) + "\n");
        }

        bw.flush();
    }
}
