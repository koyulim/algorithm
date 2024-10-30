import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int node;
        List<Edge> edges;
        Node (int node) {
            this.node = node;
            edges = new ArrayList<>();
        }
    }

    static class Edge {
        int node;
        int weight;
        Edge (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ve = br.readLine().split(" ");
        int v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);
        int start = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int star = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[star].edges.add(new Edge(end, weight));
        }

        int[] mdt = new int[v + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[start] = 0;

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.node;
            int weight = edge.weight;

            if (mdt[node] < weight) continue;
            
            for (Edge next : nodes[node].edges) {
                int nextNode = next.node;
                int nextWeight = next.weight;

                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edge(nextNode, mdt[node] + nextWeight));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (mdt[i] == Integer.MAX_VALUE) bw.write("INF" + "\n");
            else bw.write(mdt[i] + "\n");
        }
        bw.flush();
    }
}
