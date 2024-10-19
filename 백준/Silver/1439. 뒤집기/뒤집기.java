import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine() + '2';
        char c = input.charAt(0);
        int cA = 0, cB = 0;

        for(int i = 1; i < input.length(); i++){
            if(c != input.charAt(i)){
                if(c == '0')cA++;
                else cB++;
                c = input.charAt(i);
            }
        }
        bw.write(Math.min(cA, cB) + "\n");
        bw.flush();
    }
}
