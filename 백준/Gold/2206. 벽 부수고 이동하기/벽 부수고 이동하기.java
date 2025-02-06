import java.io.*;
import java.util.*;
import java.util.Queue;
import java.awt.*;

public class Main {

    private static class Node {
        int x;
        int y;
        int wall;
        int cnt;
        Node (int x, int y, int wall, int cnt) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };

        int[][] list = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = str.charAt(j) - '0';
            }
        }

        visit[0][0][0] = true;
        queue.add(new Node(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            int wall = node.wall;

            if (x == n - 1 && y == m - 1) {
                bw.write(cnt + "\n");
                bw.flush();
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (list[nx][ny] == 1 && wall == 0 &&!visit[nx][ny][1]) {
                        queue.add(new Node(nx, ny, 1, cnt + 1));
                        visit[nx][ny][1] = true;
                    } 
                    
                    if (list[nx][ny] == 0 && !visit[nx][ny][wall]) {
                        queue.add(new Node(nx, ny, wall, cnt + 1));
                        visit[nx][ny][wall] = true;
                    }

                }
            }
        }
        
        bw.write("-1" + "\n");
        bw.flush();
    }
}
