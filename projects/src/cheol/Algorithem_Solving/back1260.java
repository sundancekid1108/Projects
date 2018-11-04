package cheol;
/*
*백준 1260문제
* 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다.

* */

import java.io.*;
import java.util.*;


public class back1260 {

    public static int[][] graph;
    public static boolean visited[]; // T,F로 구분
    public static int N;
    public static int E;
    public static int startPoint;

    public static void dfs(int i){
        visited[i] = true;
        System.out.println(i + " " );
        for(int j=1; j<=N; j++){
            if(graph[i][j] == 1 && visited[j] == false){
                dfs(j);
            }
        }
    }

    public  static void bfs(int i){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        visited[i] = true;

    }

    public static void main(String[] ar){


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[1001][1001];
        E = sc.nextInt();
        visited = new boolean[10001];
        startPoint = sc.nextInt();

        int a,b;

        for(int i=1; i<=E; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(startPoint);

    }



} 