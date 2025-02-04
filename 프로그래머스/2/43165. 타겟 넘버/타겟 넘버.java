class Solution {
    
    static int answer;
    static int tarGet;
    static int[] list;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        tarGet = target;
        list = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            list[i] = numbers[i];
        }
        
        dfs(numbers[0], 1);
        dfs(numbers[0] * -1, 1);
        return answer;
    }
    
    private static void dfs(int val, int cnt) {
        if (cnt == list.length && val == tarGet) {
            answer++;
            return;
        }
        
        if (cnt >= list.length) {
            return;
        }
        
        dfs(val + list[cnt], cnt + 1);
        dfs(val - list[cnt], cnt + 1);
        
    }
}