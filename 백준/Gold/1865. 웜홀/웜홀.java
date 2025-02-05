import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int node;
        List<Edge> edges;

        Node(int node) {
            this.node = node;
            edges = new ArrayList();
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

        int size = Integer.parseInt(br.readLine());
        for (int z = 0; z < size; z++) {
            String[] nmw = br.readLine().split(" ");
            int n = Integer.parseInt(nmw[0]);
            int m = Integer.parseInt(nmw[1]);
            int w = Integer.parseInt(nmw[2]);

            Node[] nodes = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m + w; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);

                if (i < m) {
                    nodes[start].edges.add(new Edge(end, weight));
                    nodes[end].edges.add(new Edge(start, weight));
                } else {
                    nodes[start].edges.add(new Edge(end, weight * -1));
                }
            }

            boolean chack = false;
            for (int i = 1; i <= n; i++) {
                if (bellmanFord(n, nodes, i)) {
                    chack = true;
                    break;
                }
            }

            bw.write(chack ? "YES\n" : "NO\n");

        }

        bw.flush();
    }

    private static boolean bellmanFord(int n, Node[] nodes, int start) {
        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[start] = 0;

        for (int i = 1; i <= n; i++) {
            boolean chack = false;
            for (int j = 1; j <= n; j++) {
                for (Edge edge : nodes[j].edges) {
                    if (mdt[j] != Integer.MAX_VALUE && mdt[edge.node] > mdt[j] + edge.weight) {
                        mdt[edge.node] = mdt[j] + edge.weight;
                        chack = true;
                        if (i == n) {
                            return true;
                        }
                    }
                }
            }
            if (!chack) break;
        }

        return false;
    }
}
