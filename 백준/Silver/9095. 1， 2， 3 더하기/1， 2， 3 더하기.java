import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int v = 0; v < size; v++) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;
    
            for (int i = 0; i <= (n/3); i++) {
                int b = (n - (3 * i)) / 2;
    
                for (int j = 0; j <= b; j++) {
                    int c = n - (3 * i) - (2 * j);
                    int total = i + j + c;
                    
                    int totalA = 1;
                    int totalB = 1;
                    int totalC = 1;
                    int totalT = 1;
    
                    for (int z = 1; z <= total; z++) {
                        if (z <= i && i != 0)totalA *= z;
                        if (z <= j && j != 0)totalB *= z;
                        if (z <= c && c != 0)totalC *= z;
                        if (z <= total)totalT *= z;
                    }
    
                    result += totalT / (totalA * totalB * totalC);
                }
            }

            bw.write(result + "\n");
        }
        
        bw.flush();
    }
}