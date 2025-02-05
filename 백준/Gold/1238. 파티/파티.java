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

        String[] nmx = br.readLine().split(" ");
        int n = Integer.parseInt(nmx[0]);
        int m = Integer.parseInt(nmx[1]);
        int x = Integer.parseInt(nmx[2]);

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

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == x) continue; 
            int start = i;
            int end = x;
            int[] mdt = new int[n + 1];
            Arrays.fill(mdt, Integer.MAX_VALUE);
            mdt[start] = 0;

            Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            queue.add(new Edge(start, 0));

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                int node = edge.node;
                int weight = edge.weight;

                if (weight > mdt[node]) {
                    continue;
                }

                for (Edge next : nodes[node].edges) {
                    int nextNode = next.node;
                    int nextWeight = next.weight;
                    if (mdt[nextNode] > mdt[node] + nextWeight) {
                        mdt[nextNode] = mdt[node] + nextWeight;
                        queue.add(new Edge(nextNode, mdt[node] + nextWeight));
                    }
                }
            }

            result[i] = mdt[end];
        }

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int start = x;
            int end = i;
            int[] mdt = new int[n + 1];
            Arrays.fill(mdt, Integer.MAX_VALUE);
            mdt[start] = 0;

            Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            queue.add(new Edge(start, 0));

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                int node = edge.node;
                int weight = edge.weight;

                if (weight > mdt[node]) {
                    continue;
                }

                for (Edge next : nodes[node].edges) {
                    int nextNode = next.node;
                    int nextWeight = next.weight;
                    if (mdt[nextNode] > mdt[node] + nextWeight) {
                        mdt[nextNode] = mdt[node] + nextWeight;
                        queue.add(new Edge(nextNode, mdt[node] + nextWeight));
                    }
                }
            }

            result[i] += mdt[end];
        }

        int answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
