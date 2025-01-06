import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class Main {

    static class Node {
        int n;
        List<Node> edges;
        Node (int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] truePeple = br.readLine().split(" ");
        int trueCnt = Integer.parseInt(truePeple[0]);
        int[] truePeples = new int[trueCnt];
        for (int i = 0; i < trueCnt; i++) {
            truePeples[i] = Integer.parseInt(truePeple[i + 1]);
        }

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            List<Integer> arr2 = new ArrayList<>();

            for (int j = 1; j <= size; j++) {
                arr2.add(Integer.parseInt(input[j]));
            }

            for (int j = 1; j < size; j++) {
                nodes[Integer.parseInt(input[j + 1])].edges.add(nodes[Integer.parseInt(input[j])]);
                nodes[Integer.parseInt(input[j])].edges.add(nodes[Integer.parseInt(input[j + 1])]);
            }

            arr.add(arr2);
        }

        boolean[] visit = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < truePeples.length; i++) {
            if (!visit[truePeples[i]]) {
                queue.add(nodes[truePeples[i]]);
                visit[truePeples[i]] = true;
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Node chile : node.edges) {
                        if (!visit[chile.n]) {
                            visit[chile.n] = true;
                            queue.add(chile);
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (List<Integer> list : arr) {
            boolean chack = true;
            for (int parson : list) {
                if (visit[parson]) {
                    chack = false;
                    break;
                }
            }
            if (chack) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.close();
    }
}
