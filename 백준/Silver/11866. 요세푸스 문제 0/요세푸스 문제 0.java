import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int rotat = k - 1;
        System.out.print("<");
        while(!queue.isEmpty()) {
            if (rotat != 0) {
                queue.add(queue.poll());
                rotat--;
            } else {
                if (queue.peek() == k) System.out.print(queue.poll());
                else System.out.print(", " + queue.poll());
                rotat = k - 1;
            }
        }
        System.out.print(">");
    }
}