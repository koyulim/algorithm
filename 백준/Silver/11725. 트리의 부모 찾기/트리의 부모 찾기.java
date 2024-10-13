import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int node;
        List<Node> edge;
        int perent;
        boolean visit;
        Node (int node) {
            this.node = node;
            edge = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[size + 1];

        for (int i = 0; i <= size; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            nodes[n].edge.add(nodes[m]);
            nodes[m].edge.add(nodes[n]);
        }

        Queue<Node> queue = new LinkedList();
        queue.add(nodes[1]);
        nodes[1].visit = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node child : node.edge) {
                if (!child.visit) {
                    child.perent = node.node;
                    queue.add(child);
                    child.visit = true;
                }
            }
        }

        for (int i = 2; i <= size; i++) {
            bw.write(nodes[i].perent + "\n");
        }

        bw.flush();
    }
}
