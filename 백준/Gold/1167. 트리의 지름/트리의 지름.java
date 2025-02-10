import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int node;
        List<Edge> edges;

        Node(int node) {
            this.node = node;
            edges = new ArrayList<>();
        }
    }

    private static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            // for (int j = 1; j < input.length - 1; j *= 2) {
            // nodes[start].edges.add(new Edge(Integer.parseInt(input[j]),
            // Integer.parseInt(input[j + 1])));
            // }
            int cnt = 1;
            while (true) {
                int end = Integer.parseInt(input[cnt]);
                if (end == -1) {
                    break;
                }
                int weight = Integer.parseInt(input[cnt + 1]);
                nodes[start].edges.add(new Edge(end, weight));
                cnt += 2;
            }
        }

        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        int[] w = new int[n + 1];
        int farth = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Edge v : node.edges) {
                if (!visit[v.node]) {
                    visit[v.node] = true;
                    queue.add(nodes[v.node]);
                    w[v.node] = v.weight + w[node.node];
                    if (w[v.node] > result) {
                        result = w[v.node];
                        farth = v.node;
                    }
                }
            }
        }

        queue.clear();
        Arrays.fill(visit, false);
        Arrays.fill(w, 0);

        queue.add(nodes[farth]);
        visit[farth] = true;
        result = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Edge v : node.edges) {
                if (!visit[v.node]) {
                    visit[v.node] = true;
                    queue.add(nodes[v.node]);
                    w[v.node] = v.weight + w[node.node];
                    result = Math.max(result, w[v.node]);
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
