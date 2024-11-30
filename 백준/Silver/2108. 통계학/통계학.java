import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int[]list = new int[size];
        for (int i = 0; i < size; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            list[i] = value;
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        // 산술평균
        int first = Math.round((float) sum / size);

        // 중앙값
        Arrays.sort(list);
        int second = list[size / 2];

        // 최빈값
        int max = Collections.max(map.values());
        List<Integer> arr = new ArrayList<>();
        for (int val : map.keySet()) {
            if (map.get(val) == max) {
                arr.add(val);
            }
        }
        Collections.sort(arr);
        int therd = arr.size() > 1 ? arr.get(1) : arr.get(0);

        // 범위
        int ford = list[size - 1] - list[0];

        bw.write(first + "\n");
        bw.write(second + "\n");
        bw.write(therd + "\n");
        bw.write(ford + "\n");
        bw.flush();
    }
}
