package Kim;

import java.util.*;
public class Dijkstra {
	public int N;				// 그래프의 정점 수
	List<Edge>[] graph;	
	public int[] previous;		// 최단경로상 이전 정점
	public Dijkstra(List<Edge>[] adjList) {	// 생성자
		N = adjList.length;
		previous = new int[N];
		graph = adjList;
	}
	
	public int[] shortestPath(int s) {		// s는 출발 정점
		boolean[] visited = new boolean[N];		// 방문이 된 정점은 true
		int[] D = new int[N];					// 최소가중치 합
		for(int i = 0; i < N; i++) {	// 초기화
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		previous[s] = 0;
		D[s] = 0;
		for(int k = 0; k < N; k++) {
			int minVertex = -1;				// D원소 값이 최소인 minVertex 찾기
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) {
				if((!visited[j]) && (D[j] < min)) {		
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;			// 최소정점 방문
			for(Edge e : graph[minVertex]) {	// minVertex에 인접한 각 정점에 대해
				if(!visited[e.adjvertex]) {		// 아직 방문 안된 정점에 대해
					int currentDist = D[e.adjvertex];
					int newDist = D[minVertex] + e.weight;
					if(newDist < currentDist) {		// D에 저장된 값 보다 현재 정점으로 이어지는 가중치의 합이 더 작으면
						D[e.adjvertex] = newDist;				// 간선완화
						previous[e.adjvertex] = minVertex;		// 최종 최단경로를 역방향으로 추출
					}
				}
			}
		}
		return D;		// 각 정점별 최단거리가 저장된 배열 리턴
	}
	
}
