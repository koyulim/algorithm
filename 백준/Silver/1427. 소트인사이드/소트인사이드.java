import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Character[] list = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            list[i] = str.charAt(i);
        }

        Arrays.sort(list, Comparator.reverseOrder());

        for (int i = 0; i < str.length(); i++) {
            bw.write(list[i] + "");
        }
        bw.write("\n");
        bw.flush();
    }
}
