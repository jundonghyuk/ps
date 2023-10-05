import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        int r = -1;
        int l = 10000010;
        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Set<Integer> gate = new HashSet<>();
        Set<Integer> summit = new HashSet<>();
        for(int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];
            int weight = paths[i][2];
            list[start].add(new int[]{end, weight});
            list[end].add(new int[]{start, weight});
            r = Math.max(r, paths[i][2]);
            l = Math.min(l, paths[i][2]);
        }
        
        int[] visitValue = new int[n+1];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < summits.length; i++) {
            summit.add(summits[i]);
            visitValue[summits[i]] = -1;
        }
        
        for(int i = 0; i < gates.length; i++) {
            gate.add(gates[i]);
            visitValue[gates[i]] = -2;
            queue.add(new int[]{gates[i], 0});
        }
        
        // gates = -2, summits = -1;
        int min = 10000010;
        int retLoc = -1;
        for(int i = 0; i < gates.length; i++) {
            int curGate = gates[i];
            int[] visited = new int[n+1];
            Arrays.fill(visited, 10000010);
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{curGate, 0});
            while(!q.isEmpty()) {
                int[] poll = q.poll();
                int loc = poll[0];
                int wei = poll[1];
                if(wei > min) {
                    continue;
                }
                // System.out.println(loc + " " + wei);
                if(summit.contains(loc)) {
                    if(min > wei) {
                        min = wei;
                        retLoc = loc;
                    } else if(min == wei) {
                        if(loc < retLoc) {
                            retLoc = loc;
                        }
                    }
                    continue;
                }
                List<int[]> arrList = list[loc];
                // System.out.println(arrList.size());

                for(int j = 0; j < arrList.size(); j++) {
                    int[] next = arrList.get(j);
                    int curWeight = Math.max(wei, next[1]);
                    if(visited[next[0]] <= curWeight) {
                        continue;
                    }
                    if(gate.contains(next[0])) {
                        continue;
                    }
                    visited[next[0]] = curWeight;
                    q.add(new int[]{next[0], curWeight});
                }
            }
        }
        return new int[]{retLoc, min};
    }
}