import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int x;
        int y;
        int k;
        int moves;
        Node (int x, int y, int k, int moves) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        String[] wh = br.readLine().split(" ");
        int w = Integer.parseInt(wh[0]); // 5 가로
        int h = Integer.parseInt(wh[1]); // 2 세로
        int[][] list = new int[h][w];

        for (int i = 0; i < h; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (w == 1 && h == 1) {
            bw.write("0" + "\n");
            bw.flush();
            return;
        }

        int[] hx = {-1, -2, 1, 2, -2, -1, 2, 1};
        int[] hy = {-2, -1, -2, -1, 1, 2, 1, 2};
        int[] bx = {0, 0, -1, 1};
        int[] by = {-1, 1, 0, 0};

        boolean[][][] visit = new boolean[h][w][k + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, k, 0));
        visit[0][0][k] = true;
        
        int result = -1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
 
            if (node.x == h - 1 && node.y == w - 1) {
                result = node.moves;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + bx[i];
                int ny = node.y + by[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visit[nx][ny][node.k] && list[nx][ny] == 0) {
                    queue.add(new Node(nx, ny, node.k, node.moves + 1));
                    visit[nx][ny][node.k] = true;
                }
            }

            if (node.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = node.x + hx[i];
                    int ny = node.y + hy[i];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visit[nx][ny][node.k - 1] && list[nx][ny] == 0) {
                        queue.add(new Node(nx, ny, node.k - 1, node.moves + 1));
                        visit[nx][ny][node.k - 1] = true;
                    }
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
