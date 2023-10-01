
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] nodeToEdge = new List[N + 1];
        List<Integer>[] edgeToNode = new List[M + 1];
        for (int i = 0; i <= N; i++) {
            nodeToEdge[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <= M; i++) {
            edgeToNode[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int node = Integer.parseInt(st.nextToken());
                nodeToEdge[node].add(i);
                edgeToNode[i].add(node);
            }
//            String line = br.readLine();
//            List<Integer> hyper = Arrays.stream(line.split(" "))
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//            for (Integer integer : hyper) {
//                nodeToEdge[integer].add(i);
//                edgeToNode[i].add(integer);
//            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 1});
        boolean[] visitedNode = new boolean[N + 1];
        boolean[] visitedEdge = new boolean[M + 1];
        visitedNode[1] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int num = poll[0];
            int isNode = poll[1];
            int weight = poll[2];
            if (num == N && isNode == 1) {
                System.out.println(weight);
                return;
            }
            if (isNode == 1) {
                List<Integer> nodeToEdges = nodeToEdge[num];
                for (Integer toEdge : nodeToEdges) {
                    if (visitedEdge[toEdge]) {
                        continue;
                    } else {
                        visitedEdge[toEdge] = true;
                        queue.add(new int[]{toEdge, 0, weight});
                    }
                }
            } else {
                List<Integer> edgeToNodes = edgeToNode[num];
                for (Integer toNode : edgeToNodes) {
                    if (visitedNode[toNode]) {
                        continue;
                    } else {
                        visitedNode[toNode] = true;
                        queue.add(new int[]{toNode, 1, weight + 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
