import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int n;
        List<Edge> edges;
        Node (int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    static class Edge {
        int n;
        int w;
        Edge (int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    static int n;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ne = br.readLine().split(" ");
        n = Integer.parseInt(ne[0]);
        int e = Integer.parseInt(ne[1]);

        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[start].edges.add(new Edge(end, weight));
            nodes[end].edges.add(new Edge(start, weight));
        }

        String[] v1v2 = br.readLine().split(" ");
        int v1 = Integer.parseInt(v1v2[0]);
        int v2 = Integer.parseInt(v1v2[1]);

        long path1 = 0;
        path1 += dijkstra(1, v1); // 1 -> v1
        path1 += dijkstra(v1, v2);      // v1 -> v2
        path1 += dijkstra(v2, n);       // v2 -> N

        long path2 = 0;
        path2 += dijkstra(1, v2); // 1 -> v2
        path2 += dijkstra(v2, v1);      // v2 -> v1
        path2 += dijkstra(v1, n);       // v1 -> N

        long result = Math.min(path1, path2);
        if (result >= Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(result + "\n");
        }
       
        bw.close();
    }

    static int dijkstra (int start, int end) {
        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(q -> q.w));
        queue.add(new Edge(start, 0));
        mdt[start] = 0;
        
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.n;
            int weight = edge.w;

            if (mdt[node] < weight) {
                continue;
            }

            for (Edge next : nodes[node].edges) {
                int nextNode = next.n;
                int nextWeight = next.w;

                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edge(nextNode, nextWeight + mdt[node]));
                }
            }
        }

        return mdt[end];
    }
}
