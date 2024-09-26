import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static class Node {
        int n;
        List<Node> neighbor;
        boolean visit;
        Node(){
           neighbor = new ArrayList<>();    
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Node> queue = new LinkedList<>();
        int size = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        Node[] node = new Node[size + 1];
        for (int i = 0; i <= size; i++) {
            node[i] = new Node();
            node[i].n = i;
        }

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            node[a].neighbor.add(node[b]);
            node[b].neighbor.add(node[a]);
        }
        
        queue.add(node[1]);

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node nodes = queue.poll();

            if (nodes.visit) {
                continue;
            } else {
                for (Node computer : nodes.neighbor) {
                    queue.add(computer);
                }
            }
            nodes.visit = true;
            cnt++;
        }

        bw.write((cnt - 1) + "\n");
        bw.flush();
    }
}