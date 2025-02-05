import java.io.*;
import java.util.*;

public class Main {

    private static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
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

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m + w; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);

                if (i < m) {
                    edges.add(new Edge(start, end, weight));
                    edges.add(new Edge(end, start, weight));
                } else {
                    edges.add(new Edge(start, end, weight * -1));
                }
            }

            boolean chack = false;
            for (int i = 1; i <= n; i++) {
                if (bellmanFord(n, edges, i)) {
                    chack = true;
                    break;
                }
            }

            bw.write(chack ? "YES\n" : "NO\n");

        }

        bw.flush();
    }

    private static boolean bellmanFord(int N, List<Edge> edges, int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i < N; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (Edge edge : edges) {
            if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
                return true;
            }
        }

        return false;
    }
}
