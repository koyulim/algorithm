import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int result = -1; // 결과값 초기화
            // x 값부터 시작해서 M씩 증가하며 확인
            for (int k = x; k <= m * n; k += m) {
                // (k-1) % N + 1 이 y와 같다면 정답
                if ((k - 1) % n + 1 == y) {
                    result = k;
                    break;
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
