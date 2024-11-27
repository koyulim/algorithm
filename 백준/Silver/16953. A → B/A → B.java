import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        long n;
        List<Node> edges;
        Node (long n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        Map<Long, Node> nodes = new HashMap<>();
        nodes.put(a, new Node(a));

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(a));

        Map<Long, Boolean> visit = new HashMap<>();
        Map<Long, Integer> cnt = new HashMap<>();

        visit.put(a, true);
        cnt.put(a, 1);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            long next = node.n * 2;
            if (next <= 1000000000 && !visit.containsKey(next)) {
                nodes.put(next, new Node(next));
                queue.add(nodes.get(next));
                visit.put(next, true);
                cnt.put(next, cnt.get(node.n) + 1);
            }

            String str = String.valueOf(node.n) + "1";
            long next2 = Long.parseLong(str);
            if (next2 <= 1000000000 && !visit.containsKey(next2)) {
                nodes.putIfAbsent(next2, new Node(next2));
                queue.add(nodes.get(next2));
                visit.put(next2, true);
                cnt.put(next2, cnt.get(node.n) + 1);
            }

            if (cnt.containsKey(b)) {
                break;
            }
        }

        bw.write(cnt.getOrDefault(b, -1) + "\n");
        bw.flush();
    }
}
