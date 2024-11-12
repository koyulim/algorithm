import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] list = new char[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char str = input.charAt(j);
                if (str == 'I') {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                }
                list[i][j] = input.charAt(j);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (list[x][y] == 'P') cnt++;
            
            if (x + 1 < n && visit[x + 1][y] == false && list[x + 1][y] != 'X') {    
                queue.add(new Point(x + 1, y));
                visit[x + 1][y] = true;
            }

            if (x > 0 && visit[x - 1][y] == false && list[x - 1][y] != 'X') {
                queue.add(new Point(x - 1, y));
                visit[x - 1][y] = true;
            }

            if (y + 1 < m && visit[x][y + 1] == false && list[x][y + 1] != 'X') {
                queue.add(new Point(x, y + 1));
                visit[x][y + 1] = true;
            }

            if (y > 0 && visit[x][y - 1] == false && list[x][y - 1] != 'X') {
                queue.add(new Point(x, y - 1));
                visit[x][y - 1] = true;
            }
        }

        if (cnt == 0) bw.write("TT" + "\n");
        else bw.write(cnt + "\n");
        bw.flush();
    }
}
