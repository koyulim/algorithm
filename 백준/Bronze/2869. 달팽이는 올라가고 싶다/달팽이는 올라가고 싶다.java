import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abv = br.readLine().split(" ");

        int result = 0;
        if (((Integer.parseInt(abv[2]) - Integer.parseInt(abv[0])) % (Integer.parseInt(abv[0]) - Integer.parseInt(abv[1]))) == 0) result = (Integer.parseInt(abv[2]) - Integer.parseInt(abv[0])) / (Integer.parseInt(abv[0]) - Integer.parseInt(abv[1]));
        else result = ((Integer.parseInt(abv[2]) - Integer.parseInt(abv[0])) / (Integer.parseInt(abv[0]) - Integer.parseInt(abv[1]))) + 1;

        bw.write((result + 1) + "\n");
        bw.flush();
    }
}
