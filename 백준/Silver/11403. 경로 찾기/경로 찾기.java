import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static class Node {
        int n;
        List<Node> edges;
        Node (int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[size];
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    nodes[i].edges.add(nodes[j]);
                }
            }
        }

        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(nodes[i]);
            
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                
                for (Node idx : node.edges) {
                    if (!visit[idx.n]) {
                        queue.add(idx);
                        visit[idx.n] = true;
                        result[i][idx.n] = 1;
                    }
                }
            }

            Arrays.fill(visit, false);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}

