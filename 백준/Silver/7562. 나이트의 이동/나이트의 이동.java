import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			int size = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			String[] input2 = br.readLine().split(" ");

			boolean[][] visit = new boolean[size][size];
			int[][] cnt = new int[size][size];
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
			visit[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
			cnt[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 0;
			while (!queue.isEmpty()) {
				Point point = queue.poll();
				int x = point.x;
				int y = point.y;

				if (x == Integer.parseInt(input2[0]) && y == Integer.parseInt(input2[1])) break;

				if (x - 2 >= 0) {
					if (y - 1 >= 0 && !visit[x - 2][y - 1]) {
						queue.add(new Point(x - 2, y - 1));
						visit[x - 2][y - 1] = true;
						cnt[x - 2][y - 1] = cnt[x][y] + 1;
					}

					if (y + 1 < size && !visit[x - 2][y + 1]) {
						queue.add(new Point(x - 2, y + 1));
						visit[x - 2][y + 1] = true;
						cnt[x - 2][y + 1] = cnt[x][y] + 1;
					}
				}

				if (x + 2 < size) {
					if (y - 1 >= 0 && !visit[x + 2][y - 1]) {
						queue.add(new Point(x + 2, y - 1));
						visit[x + 2][y - 1] = true;
						cnt[x + 2][y - 1] = cnt[x][y] + 1;
					}

					if (y + 1 < size && !visit[x + 2][y + 1]) {
						queue.add(new Point(x + 2, y + 1));
						visit[x + 2][y + 1] = true;
						cnt[x + 2][y + 1] = cnt[x][y] + 1;
					}
				}

				if (y - 2 >= 0) {
					if (x - 1 >= 0 && !visit[x - 1][y - 2]) {
						queue.add(new Point(x - 1, y - 2));
						visit[x - 1][y - 2] = true;
						cnt[x - 1][y - 2] = cnt[x][y] + 1;
					}

					if (x + 1 < size && !visit[x + 1][y - 2]) {
						queue.add(new Point(x + 1, y - 2));
						visit[x + 1][y - 2] = true;
						cnt[x + 1][y - 2] = cnt[x][y] + 1;
					}
				}

				if (y + 2 < size) {
					if (x - 1 >= 0 && !visit[x - 1][y + 2]) {
						queue.add(new Point(x - 1, y + 2));
						visit[x - 1][y + 2] = true;
						cnt[x - 1][y + 2] = cnt[x][y] + 1;
					}

					if (x + 1 < size && !visit[x + 1][y + 2]) {
						queue.add(new Point(x + 1, y + 2));
						visit[x + 1][y + 2] = true;
						cnt[x + 1][y + 2] = cnt[x][y] + 1;
					}
				}

			}
			bw.write(cnt[Integer.parseInt(input2[0])][Integer.parseInt(input2[1])] + "\n");
		}

		bw.flush();
	}
}