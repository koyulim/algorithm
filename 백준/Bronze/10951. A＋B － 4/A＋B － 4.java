import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";

        while ((input = br.readLine()) != null) {
            String[] list = input.split(" ");

            int a = Integer.parseInt(list[0]);
            int b = Integer.parseInt(list[1]);
            bw.write((a + b) + "\n");
        }

        
        bw.flush();
    }
}