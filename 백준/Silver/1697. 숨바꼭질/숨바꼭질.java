import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static class Node{
        int n;
        List<Node> edge;
        boolean visit;
        int cnt;

        Node(int n){
            this.n = n;           
            edge = new ArrayList<>();
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
    
        Node[] nodes = new Node[100000 + 1];
        for (int i = 0; i <= 100000; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i <= 100000; i++) {
            if (i > 0) nodes[i].edge.add(nodes[i - 1]);
            if (i < 100000) nodes[i].edge.add(nodes[i + 1]);
            if ((i * 2) <= 100000) nodes[i].edge.add(nodes[i * 2]);
        }
       
        Queue<Node> queue = new LinkedList<>();
        nodes[n].visit = true;
        queue.add(nodes[n]);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node person : node.edge) {
                if (!person.visit) {
                    person.cnt = node.cnt + 1;
                    person.visit = true;
                    queue.add(person);
                }
            }
        }
        
        bw.write(nodes[m].cnt + "\n");
        bw.flush();
    }
}
