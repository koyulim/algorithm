import java.io.*;
import java.util.*;

public class Main {

    static char[][] list;
    static int r, c, max;
    static HashSet<Character> visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        max = 0;
        list = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                list[i][j] = str.charAt(j);
            }
        }
        visit = new HashSet<>();
        backTraking(0, 0, 1);
        bw.write(max + "\n");
        bw.flush();
    }

    private static void backTraking(int x, int y, int cnt) {
        max = Math.max(max, cnt);
        visit.add(list[x][y]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visit.contains(list[nx][ny])) {
                    backTraking(nx, ny, cnt + 1);
                }
            }
        }

        visit.remove(list[x][y]);
    }
}
