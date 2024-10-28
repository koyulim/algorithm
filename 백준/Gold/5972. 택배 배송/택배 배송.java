import java.util.*;
import java.io.*;
import java.awt.Point;

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
            nodes[end].edges.add(new Edge(start, weight));
        }

        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[1] = 0;

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.add(new Edge(1, 0)); // 출발점인 시작 노드 1과 자기 자신과의 거리 0 추가

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.node;
            int weight = edge.weight;

            // mdt 배열값이 현재 값보다 작으면 무시
            if (weight > mdt[node]) {
                continue;
            }

            for (Edge next : nodes[node].edges) {
                int nextNode = next.node;
                int nextWeight = next.weight;

                // 더 짧은 노드 mdt 값 변경, 큐에 추가
                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edge(nextNode, nextWeight + mdt[node]));
                }
            }
        }

        bw.write(mdt[n] + "\n");
        bw.flush();
    }
}
