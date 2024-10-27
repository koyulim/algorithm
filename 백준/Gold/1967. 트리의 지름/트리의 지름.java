import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int n;
        List<Edge> edges;

        Node(int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    static class Edge {
        Node n;
        int w;

        Edge(Node n, int w) {
            this.n = n;
            this.w = w;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        if (size == 1) {
            bw.write(0 + "\n");
        } else {

            Node[] nodes = new Node[size + 1];
            for (int i = 1; i <= size; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < size - 1; i++) {
                String[] input = br.readLine().split(" ");
                int parent = Integer.parseInt(input[0]);
                int child = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);

                nodes[parent].edges.add(new Edge(nodes[child], weight));
                nodes[child].edges.add(new Edge(nodes[parent], weight));
            }

            Stack<Node> stack = new Stack<>();
            boolean[] visit = new boolean[size + 1];
            int[] distance = new int[size + 1];
            stack.add(nodes[1]);
            visit[1] = true;

            int first = 0;
            int max = 0;

            while (!stack.empty()) {
                Node node = stack.pop();

                for (Edge child : node.edges) {
                    if (!visit[child.n.n]) {
                        visit[child.n.n] = true;
                        distance[child.n.n] = distance[node.n] + child.w;
                        stack.add(child.n);

                        if (distance[child.n.n] > max) {
                            max = distance[child.n.n];
                            first = child.n.n;
                        }
                    }
                }
            }

            stack.clear();
            Arrays.fill(distance, 0);
            Arrays.fill(visit, false);

            stack.add(nodes[first]);
            visit[first] = true;
            max = 0;
            while (!stack.empty()) {
                Node node = stack.pop();
                for (Edge child : node.edges) {
                    if (!visit[child.n.n]) {
                        visit[child.n.n] = true;
                        distance[child.n.n] = distance[node.n] + child.w;
                        stack.add(child.n);

                        if (distance[child.n.n] > max) {
                            max = distance[child.n.n];
                        }
                    }
                }
            }
            bw.write(max + "\n");
        }
        bw.flush();
    }
}
