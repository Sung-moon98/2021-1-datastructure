package Kim;

import java.util.*;
public class Kosaraju {
	int N;					// 정점 수
	boolean[] visited;		
	List<Integer> seq;		// 위상정렬 순서
	List<Edge>[] graph;		// 역순 그래프
	
	public Kosaraju(List<Integer> seq, List<Edge>[] adjList) {
		this.seq = seq;
		graph = adjList;
		N = adjList.length;
		visited = new boolean[N];
		for(int i = 0; i < N; i++)	visited[i] = false;		// 배열 초기화
		System.out.println("강연결성분: ");
		for(int i = 0; i < N; i++) {
			int t = seq.get(i);							// t는 위상정렬순서
			if(!visited[t]) {
				System.out.print("[");
				dfs(t);									// 위상정렬순서로 깊이우선탐색
				System.out.println("] ");
			}
		}
	}
	private void dfs(int i) {	
		visited[i] = true;					// 정점 i가 방문되어 true로 만든다
		System.out.print(i);			// 정점 i를 방문
		for(Edge e: graph[i]) {				// 정점 i에 인접한 각 정점에 대해
			if(!visited[e.adjvertex]) {		// 정점 i에 인접한 정점이 방문이 안되어있으면
				System.out.print(", ");
				dfs(e.adjvertex);			// 재귀호출
			}
	}
}
		
	
	
	

	
}
