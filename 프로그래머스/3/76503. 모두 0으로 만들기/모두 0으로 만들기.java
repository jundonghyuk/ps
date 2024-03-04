import java.util.*;

class Solution {
    
    static List<Integer>[] adj;
    static boolean[] visited;
    static long cnt = 0;
    static long[] arr;
    
    public long solution(int[] a, int[][] edges) {
        int len = a.length;
        arr = new long[len];
        adj = new List[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = (long)a[i];
            adj[i] = new ArrayList<>();
            sum += arr[i];
        }
        
        if(sum != 0) {
            return -1;
        }
        
        visited = new boolean[len];
        for (int i = 0; i < len - 1; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        dfs(0);
        return cnt;
    }
    
    public long dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < adj[node].size(); i++) {
            int next = adj[node].get(i);
            if (visited[next]) continue;
            arr[node] += dfs(next);
        }
        cnt += Math.abs(arr[node]);
        return arr[node];
    }
}