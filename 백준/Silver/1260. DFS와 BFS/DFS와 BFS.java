import java.util.*;
import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;

    static class Node {
        int node;
        List<Node> edges;
        
        Node(int value) {
            this.node = value;
            edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        visit = new boolean[n + 1];

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] val = br.readLine().split(" ");
            int start = Integer.parseInt(val[0]);
            int end = Integer.parseInt(val[1]);

            nodes[start].edges.add(nodes[end]);
            nodes[end].edges.add(nodes[start]);
        }

        for (int i = 1; i <= n; i++) {
            nodes[i].edges.sort(Comparator.comparingInt(e -> e.node));
        }

        dfs(nodes[v]);
        bw.write("\n");
        Arrays.fill(visit, false);
        bfs(nodes[v]);
        bw.write("\n");
        bw.flush();
    }

    private static void dfs(Node v) throws Exception {
        visit[v.node] = true;
        bw.write(v.node + " ");

        for (Node neighbor : v.edges) {
            if (!visit[neighbor.node]) {
                dfs(neighbor);
            }
        }
    }

    private static void bfs(Node v) throws Exception {
        Queue<Node> queue = new LinkedList<>();
        queue.add(v);
        visit[v.node] = true; 

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            bw.write(node.node + " ");

            for (Node neighbor : node.edges) {
                if (!visit[neighbor.node]) {
                    visit[neighbor.node] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
