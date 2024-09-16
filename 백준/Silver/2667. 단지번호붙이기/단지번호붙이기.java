import java.util.*;
import java.awt.Point;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arry = new int[n][n];
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String cols = sc.next();
			for (int j = 0; j < n; j++) {
				arry[i][j] = cols.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arry[i][j] == 1) {
					Queue<Point> queue = new LinkedList<Point>();
					queue.offer(new Point(i, j));
					arry[i][j]++;
                    int cnt = 1;
					while (!queue.isEmpty()) {
						Point p = queue.poll();
						int x = p.x;
						int y = p.y;
                        
						if (y + 1 < n) {
							if(arry[x][y + 1] == 1) {
							    arry[x][y + 1]++;
							    queue.offer(new Point(x, y + 1));
							    cnt++;
							}
						}
						if (y > 0) {
						    if(arry[x][y - 1] == 1) {
							    arry[x][y - 1]++;
							    queue.offer(new Point(x, y - 1));
							    cnt++;
							}
						}
						if (x + 1 < n) {
							if(arry[x + 1][y] == 1) {
							    arry[x + 1][y]++;
							    queue.offer(new Point(x + 1, y));
							    cnt++;
							}
						}
						if (x > 0) {
							if(arry[x - 1][y] == 1) {
							    arry[x - 1][y]++;
							    queue.offer(new Point(x - 1, y));
							    cnt++;
							}
						}
					}
					result.add(cnt);
				}
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) {
		    System.out.println(result.get(i));
		}
		
	}
}

