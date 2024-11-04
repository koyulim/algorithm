import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String P = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.replace("[", "").replace("]", "").replace(" ", "");
            String[] inputNumber = input.split(",");
            LinkedList<Integer> queue = new LinkedList<>();

            for (int j = 0; j < size; j++) queue.add(Integer.parseInt(inputNumber[j]));
            boolean chack = false;
            boolean error = false;
            for (int j = 0; j < P.length(); j++) {
                if (P.charAt(j) == 'R') chack = !chack;
                else if (P.charAt(j) == 'D') {
                    if (queue.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (chack) queue.removeLast();
                    else queue.removeFirst();
                }
            }

            if (error) bw.write("error" + "\n");
            else {
                bw.write("[");
                while (!queue.isEmpty()) {
                    if (chack) bw.write(queue.removeLast().toString());
                    else bw.write(queue.removeFirst().toString());
                    if (!queue.isEmpty()) bw.write(",");
                }
                bw.write("]" + "\n");
            }
        }
        bw.flush();
    }
}
