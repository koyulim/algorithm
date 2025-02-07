import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        int leng = str.length();
        int lenghts = 0;
        int result = 0;
        while (lenghts < leng) {
            
            if (lenghts + 3 <= leng && set.contains(str.substring(lenghts, lenghts + 3))) {
                lenghts += 3;
            } else if (lenghts + 2 <= leng && set.contains(str.substring(lenghts, lenghts + 2))) {
                lenghts += 2;
            } else {
                lenghts += 1;
            }
            
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
