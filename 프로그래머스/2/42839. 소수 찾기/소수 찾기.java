import java.util.*;

class Solution {
    
    static int[] list;
    static boolean[] visit;
    static int[] temp;
    static int n;
    static int m;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        list = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            list[i] = Character.getNumericValue(numbers.charAt(i));
        }
        n = numbers.length();
        Arrays.sort(list);
        
        for (int i = 0; i < numbers.length(); i++) {
            m = i + 1;
            temp = new int[m];
            visit =  new boolean[n];
            backtracking(0);
            Arrays.fill(visit, false);
            
        }
        
        for (int val : set) {
            boolean check = true;
            if (val != 1 && val != 0) {
                for (int i = 2; i < val; i ++) {
                    if ((val % i) == 0) {
                        check = false;
                    }
                }
                if (check) {
                    answer++;
                }
            }
        }
        
        return answer;
    }


    public static void backtracking(int depth) {
        if (depth == m) {
            String str = "";
            for (int i = 0; i < temp.length; i++) {
                str += String.valueOf(temp[i]);
            }
            set.add(Integer.parseInt(str));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            temp[depth] = list[i];
            backtracking(depth + 1);
            visit[i] = false;
        }
    }
}