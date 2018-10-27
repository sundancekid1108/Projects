package young;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제번호 : 1260번
 * 문제제목 : DFS와 BFS
 * 작 성 자 : Ryan Yun
 * 
 * 문제내용 : 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 적은 것을 먼저 방문하고, 더이상 방문할 수 있는 점이 없는 경우 종료한다.  
 * 정점 번호는 1번부터 N번까지이다.
 * 
 * 입   력 : 첫째 줄에 정점의 개수 N(1<=n<=1,000), 간선의 개수 M(1<=M<=10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 한 간선이 여러번 주어질 수도 있는데, 간선이 하나만 있는 것으로 
 * 생각하면 된다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * 출   력 : 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
 * V부터 방문된 점을 순서대로 출력하면 된다. 
 */
public class baekjoon_1260 {
	
	public static int N, M, V; // 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V
	public static int x, y;
	
	public static int[][] graph = new int[1001][1001];
	public static boolean visited[] = new boolean[10001];	// 방문 완료한 정점의 목
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		// 두 정점을 2차원 배열에 저장
		// 양방향 그래프이므로 graph[x][y] = graph[y][x] = 1 로 저장
		for(int i = 1; i <= M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			graph[x][y] = graph[y][x] = 1;
		}
		
		DFS(V);
		
		// 방문한 정점 리스트 초기화 
		for(int i = 1; i <= N; i++) {
			visited[i] = false;
		}
		
		System.out.println();
		BFS(V);
		
		sc.close();
	}

	// 깊이 우선 탐색
	public static void DFS(int V) {
		
		System.out.print(V + " ");
		visited[V] = true;
		
		for(int i = 1; i <= N; i++) {
			if(graph[V][i] == 1 && visited[i] == false) {
				DFS(i);
			}
		}
	}
	
	// 너비 우선 탐색  
	public static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int out;
		
		// 큐에 시작점 추가
		queue.offer(V);
		visited[V] = true;
		System.out.print(V + " ");
		
		// 큐에값이 없을 때까지 실행함
		while(!queue.isEmpty()) {
			// 큐에서 값을 꺼냄
			out = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(graph[out][i] == 1 && visited[i] == false) {
					// 방문안한 점을 찾으면 큐에 저장
					queue.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
	}
}
