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
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i); 
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            nodes[a].edges.add(nodes[b]);
            nodes[b].edges.add(nodes[a]);
        }

        int[] list = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        int[] cnt = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(nodes[i]);
            visit[i] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (Node bacon : node.edges) {
                    if (!visit[bacon.n]) {
                        queue.add(bacon);
                        visit[bacon.n] = true;
                        cnt[bacon.n] = cnt[node.n] + 1;
                    }
                }
            }

            int total = 0;
            for (int j = 0; j <= n; j++) {
                total += cnt[j];
            }

            list[i] = total;

            Arrays.fill(visit, false);
            Arrays.fill(cnt, 0);
        }

        int result = Integer.MAX_VALUE;
        int answer = 0;
        for (int j = 1; j <= n; j++) {
            if (result > list[j]) {
                result = list[j];
                answer = j;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}

