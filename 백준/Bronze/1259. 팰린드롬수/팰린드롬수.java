import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String n = br.readLine();
            if (n.equals("0")) break;
            int size = n.length();
            char[] list = new char[size];

            for (int i = 0; i < size; i++) {
                list[i] = n.charAt(i);
            }

            boolean result = true;
            for (int i = 0; i < size / 2; i++) {
                if (list[i] != list[size - 1 - i]) {
                    result = false;
                    break;
                }
            }

            if (result) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }

        bw.flush();
    }
}
