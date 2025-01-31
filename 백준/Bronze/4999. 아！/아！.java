import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if (str1.length() < str2.length()) {
            bw.write("no" + "\n");
        } else {
            bw.write("go" + "\n");
        }
        bw.flush();
    }
}
