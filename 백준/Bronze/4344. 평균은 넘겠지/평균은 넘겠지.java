import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int tatal = 0;
            for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                tatal += Integer.parseInt(input[j + 1]);
            }
            int avg = tatal / Integer.parseInt(input[0]);
            int cnt = 0;
            for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                if (Integer.parseInt(input[j + 1]) > avg) {
                    cnt++;
                }
            }
            
            double result = 0;
            int value = cnt;
            double d = 1.0;
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    result += value / Integer.parseInt(input[0]);
                } else if (j == 5) {
                    if ((value / Integer.parseInt(input[0])) > 5) {
                        result += value / Integer.parseInt(input[0]) / d;
                        result += 0.00001;
                    } else {
                        result += value / Integer.parseInt(input[0]) / d;
                    }

                } else {
                    result += value / Integer.parseInt(input[0]) / d;
                }

                d = d * 10.0;
                value = value % Integer.parseInt(input[0]) * 10;
            }
            
            bw.write((Math.round(result * 100 * 1000) / 1000.0) + "%" + "\n");
        }

        bw.flush();
    }
}
