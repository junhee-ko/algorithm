package bj_1260;

import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static Scanner sc = new Scanner(System.in);
    static int n, m, start;


    //초기화
    public static void init() {

        //정점개수, 간선개수, 시작점 입력
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //인접리스트 초기화
        arr = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = new ArrayList<Integer>();

        //간선 연결
        for (int i = 0; i < m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();

            arr[u].add(v);
            arr[v].add(u);
        }

        //오름차순 정렬
        for (int i = 1; i <= n; i++)
            Collections.sort(arr[i]);

        //방문지점 체크 배열 생성
        visit = new boolean[n + 1];

        return;
    }


    //dfs
    public static void dfs(int point) {

        //방문한 지점이면
        if (visit[point])
            return;

        //방문했으면 true로
        visit[point] = true;
        System.out.print(point + " ");

        for (int nodeNum : arr[point]) {
            if (visit[nodeNum] == false) {
                dfs(nodeNum);
            }
        }
    }

    //bfs
    public static void bfs(int point){

        //방문 지점 초기화, 큐 생성
        Arrays.fill(visit, false);
        Queue<Integer> queue = new LinkedList<Integer>();

        //큐에 넣고, 방문 했다고 체크
        queue.add(point);
        visit[point] = true;
        
        //모든 지점을 방문할 때까지
        while (!queue.isEmpty()) {

            int visitNode = queue.remove();
            System.out.print(visitNode + " ");

            //해당지점에서 연결된 노드를 방문했는지. 방문 안했으면 큐에 넣기
            for (int nodeNum : arr[visitNode]) {
                if (visit[nodeNum] == false) {
                    visit[nodeNum] = true;
                    queue.add(nodeNum);
                }
            }
        }

    }

    //main
    public static void main(String args[]) {
        init();
        dfs(start);
        System.out.println();

        bfs(start);
        System.out.println();
    }
}
