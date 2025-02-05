import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int node;
        List<Edge> edges;
        Node (int node) {
            this.node = node;
            edges = new ArrayList<>();
        }
        
    }

    private static class Edge {
        int node;
        int weight;
        Edge (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
    }

    public static void main(String[] args) throws IOException {
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
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[start].edges.add(new Edge(end, weight));
        }

        long[] mdt = new long[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[1] = 0;

        boolean chack = false;
        for (int i = 1; i <= n; i++) {
            boolean update = false;
            for (int j = 1; j <= n; j++) {
                for (Edge edge : nodes[j].edges) {
                    if (mdt[j] != Integer.MAX_VALUE && mdt[edge.node] > mdt[j] + edge.weight) {
                        mdt[edge.node] = mdt[j] + edge.weight;
                        update = true;

                        if (i == n) {
                            chack = true;
                        }
                    }
                }
            }

            if (!update) break;
        }

        if (chack) {
            bw.write("-1" + "\n");
        } else {
            for (int i = 2; i <= n; i++) {
                if (mdt[i] == Integer.MAX_VALUE) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(mdt[i] + "\n");
                }
            }
        }

        bw.flush();
    }
}
