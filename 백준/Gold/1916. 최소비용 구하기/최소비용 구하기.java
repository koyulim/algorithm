import java.util.*;
import java.io.*;

public class Main {
    
    static class Node {
        int node;
        List<Edgz> edgzs;
        Node (int node) {
            this.node = node;
            edgzs = new ArrayList<>();
        }
    }

    static class Edgz {
        int node;
        int weight;
        Edgz (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[start].edgzs.add(new Edgz(end, weight));
        }

        String[] startEnd = br.readLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        int[] mdt = new int[n + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[start] = 0;

        Queue<Edgz> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.add(new Edgz(start, 0));

        while (!queue.isEmpty()) {
            Edgz edgz = queue.poll();
            int node = edgz.node;
            int weight = edgz.weight;

            if (mdt[node] < weight) continue;

            for (Edgz next : nodes[node].edgzs) {
                int nextNode = next.node;
                int nextWeight = next.weight;
                
                if (mdt[nextNode] > mdt[node] + nextWeight) {
                    mdt[nextNode] = mdt[node] + nextWeight;
                    queue.add(new Edgz(nextNode, mdt[node] + nextWeight));
                }
            }
        }

        bw.write(mdt[end] + "\n");
        bw.flush();
    }
}
