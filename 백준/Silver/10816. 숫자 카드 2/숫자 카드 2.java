import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    // 입력 값
    // 10
    // 6 3 2 10 10 10 -10 -10 7 3
    // 8
    // 10 9 -5 2 3 4 5 -10

    // 출력 값
    // 3 0 0 1 2 0 0 2
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(input[i]);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(input[i]);
            bw.write(map.getOrDefault(value, 0) + " ");
        }
        
        bw.flush();
    }
}
