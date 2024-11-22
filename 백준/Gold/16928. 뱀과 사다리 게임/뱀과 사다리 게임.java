import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static class Node {
        int n;
        List<Node> edges;
        Node (int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");

        Node[] nodes = new Node[101];
        for (int i = 1; i < 101; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < 95; i++) {
            for (int j = 1; j < 7; j++) {
                nodes[i].edges.add(nodes[i + j]);
            }
        }

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] list = new int[101];
        for (int i = 0; i < n + m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[101];
        int[] cnt = new int[101];
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < 7; i++) {
                int next = node + i;
                if (next > 100) continue;

                if (list[next] !=0 ) {
                    next = list[next];
                }

                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                    cnt[next] = cnt[node] + 1;

                    if (next == 100) {
                        bw.write(cnt[next] + "\n");
                    }
                }
            }
        }

        bw.flush();
    }
}
